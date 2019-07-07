package intern.management_working.services

import intern.management_working.models.database.BallotRequest
import intern.management_working.models.response.SystemResponse
import org.bson.Document
import org.springframework.http.ResponseEntity

interface BallotRequestService {

    ResponseEntity<SystemResponse> create(BallotRequest ballotRequest)

    List<Document> findByUserId(String userId)
}
