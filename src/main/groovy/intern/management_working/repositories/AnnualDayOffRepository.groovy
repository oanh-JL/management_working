package intern.management_working.repositories

import intern.management_working.models.database.AnnualDayOff
import org.bson.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface AnnualDayOffRepository extends MongoRepository<AnnualDayOff, String> {

//    @Query(value ="{?0}", fields = "{_id:0}")
//    List<Document> getAllDayOff()
}