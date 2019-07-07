package intern.management_working.services

import intern.management_working.models.database.User
import intern.management_working.models.response.PageResponse
import intern.management_working.models.response.SystemResponse
import org.bson.Document
import org.springframework.http.ResponseEntity

interface UserService {
    ResponseEntity<SystemResponse> create(User user)

    PageResponse<User> findAllPagingUser(int page, int size, String sortBy, String sortDirection)

    ResponseEntity<SystemResponse> update(User user)

    ResponseEntity<SystemResponse> delete(String userId)
}