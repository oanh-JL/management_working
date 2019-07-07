package intern.management_working.repositories

import intern.management_working.models.database.Role
import org.springframework.data.mongodb.repository.MongoRepository

interface RoleRepository extends MongoRepository<Role, String> {

}