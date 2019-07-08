package intern.management_working.services.implement

import intern.management_working.models.database.BallotRequest
import intern.management_working.models.response.SystemResponse
import intern.management_working.repositories.BallotRequestRepository
import intern.management_working.services.BallotRequestService
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.aggregation.LookupOperation
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BallotRequestServiceImpl implements BallotRequestService {

    @Autowired
    BallotRequestRepository repository
    @Override
    ResponseEntity<SystemResponse> create(BallotRequest ballotRequest) {
            return repository.save(ballotRequest)
    }

    @Override
    List<Document> findByUserId(String userId) {
//        LookupOperation lookupOperation = LookupOperation.newLookup().from("ballot_requests").localField("user_id")
//                                                         .localFields
    return  null
    }
}
