package intern.management_working.controllers

import intern.management_working.models.database.BallotRequest
import intern.management_working.models.response.SystemResponse
import intern.management_working.services.BallotRequestService
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ballot_request")
class BallotRequestController {

    @Autowired
    BallotRequestService service

    @PostMapping
    ResponseEntity<SystemResponse> create(
            @RequestBody BallotRequest ballotRequest) {
        return service.create(ballotRequest)
    }

    @GetMapping("/{user_id}")
    List<Document> findByUserId (
            @PathVariable("user_id") String userId ) {
        return service.findByUserId(userId)
    }

}
