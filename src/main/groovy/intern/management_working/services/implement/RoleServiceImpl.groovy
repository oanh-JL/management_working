package intern.management_working.services.implement

import intern.management_working.models.database.Role
import intern.management_working.models.response.SystemResponse
import intern.management_working.repositories.RoleRepository
import intern.management_working.services.RoleService
import intern.management_working.services.validator.RoleValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository repository
    @Autowired
    RoleValidator validator

    @Override
    ResponseEntity<SystemResponse> create(Role role) {
        validator.create(role)
        return new ResponseEntity<SystemResponse>(SystemResponse.systemResponseMap.get("inserted"), HttpStatus.OK)
    }

    @Override
    ResponseEntity<SystemResponse> retrieve(String userId) {
        return null
    }
}
