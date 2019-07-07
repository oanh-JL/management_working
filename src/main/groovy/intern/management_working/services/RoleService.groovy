package intern.management_working.services

import intern.management_working.models.database.Role
import intern.management_working.models.response.SystemResponse
import org.springframework.http.ResponseEntity

interface RoleService {

    ResponseEntity<SystemResponse> create(Role role)
    ResponseEntity<SystemResponse> retrieve(String userId)
}