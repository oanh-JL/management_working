package intern.management_working.repositories

import intern.management_working.models.database.AnnualDayOff
import org.springframework.data.mongodb.repository.MongoRepository

interface AnnualDayOffRepository extends MongoRepository<AnnualDayOff, String> {

}