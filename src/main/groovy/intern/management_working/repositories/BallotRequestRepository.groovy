package intern.management_working.repositories

import intern.management_working.models.database.BallotRequest
import org.bson.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface BallotRequestRepository extends MongoRepository<BallotRequest, String> {
    @Query(value = "{?0}", fields = "{_id:0 }")
    List<Document> findByUserId(String userId)
}