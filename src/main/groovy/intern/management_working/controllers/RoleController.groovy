package intern.management_working.controllers

import intern.management_working.models.database.Role
import intern.management_working.models.response.SystemResponse
import intern.management_working.services.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/role")
class RoleController {

    @Autowired
    RoleService service

    @PostMapping
    ResponseEntity<SystemResponse> create(@RequestBody Role role) {
        return service.create(role)
    }

    @GetMapping("/{user_id}")
    ResponseEntity<SystemResponse> retrieve(@PathVariable("user_id") String userId) {
        return service.retrieve(userId)
    }
}
