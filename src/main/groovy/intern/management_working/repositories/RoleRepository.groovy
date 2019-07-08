package intern.management_working.repositories

import intern.management_working.models.database.Role
import org.bson.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query


interface RoleRepository extends MongoRepository<Role, String> {

    @Query(value = "{?0}", fields = "{role_name:1, parent_role:1, _id:0, _class:0}")
    Document findByRoleId(String roleId)
}