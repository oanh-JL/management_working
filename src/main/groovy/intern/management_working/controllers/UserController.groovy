package intern.management_working.controllers

import intern.management_working.models.database.User
import intern.management_working.models.response.PageResponse
import intern.management_working.models.response.SystemResponse
import intern.management_working.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    UserService service

    @PostMapping
    ResponseEntity<SystemResponse> create(
            @RequestBody User user) {
        return service.create(user)
    }

    @GetMapping
    PageResponse getAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(name = 'sort_by') String sortBy,
            @RequestParam(name = 'sort_direction') String sortDirection) {
        return service.findAllPagingUser(page, size, sortBy, sortDirection)
    }

    @PutMapping
    ResponseEntity<SystemResponse> update(
            @RequestBody User user ) {
       return service.update(user)
    }
    @DeleteMapping("/{user_id}")
    ResponseEntity<SystemResponse> delete(
            @PathVariable("user_id") String userId
    ) {
        return service.delete(userId)
    }

}
