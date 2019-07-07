package intern.management_working.services.implement

import intern.management_working.models.database.User
import intern.management_working.models.response.PageResponse
import intern.management_working.models.response.SystemResponse
import intern.management_working.repositories.UserRepository
import intern.management_working.services.UserService
import intern.management_working.services.transfer.UserTransfer
import intern.management_working.services.validator.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserServiceImpl implements UserService {
    @Autowired
    UserValidator validator
    @Autowired
    UserTransfer transfer
    @Autowired
    UserRepository repository
    @Autowired
    MongoTemplate mongoTemplate


    @Override
    ResponseEntity<SystemResponse> create(User user) {
        if (validator.create(user)) {
            transfer.create(user)
            repository.save(user)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("error"), HttpStatus.BAD_REQUEST)
    }

    @Override
    PageResponse<User> findAllPagingUser(int page, int size, String sortBy, String sortDirection) {
        Sort.Direction direction = (sortDirection == "ASC") ?
                Sort.Direction.ASC : Sort.Direction.DESC
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy))
        Page<User> pages = this.repository.findAllPagingUser(pageable)
        PageResponse<User> pageResponse = new PageResponse(
                pages.toList(),
                pages.pageable,
                pages.totalElements) as PageResponse<User>
        return pageResponse
    }

    @Override
    ResponseEntity<SystemResponse> update(User user) {
        if (validator.update(user)) {
            transfer.update(user)
            repository.save(user)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("updated"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("error"), HttpStatus.BAD_REQUEST)
    }

    @Override
    ResponseEntity<SystemResponse> delete(String userId) {
        Optional<User> userFound = repository.findByUserId(userId)
        User userFoundParse = userFound.orElse(null)
        if(userFoundParse) {
            repository.delete(userFoundParse)
            return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("deleted"), HttpStatus.OK)
        }
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("error"), HttpStatus.BAD_REQUEST)
    }
}
