package intern.management_working.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

import java.time.Instant

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "roles")
class Role {
    @Id
    String _id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    String roleId
    @Indexed(unique = true, dropDups = true)
    String roleName
    @DBRef
    Role parentRole
    Instant createdAt
    Instant modifiedAt

}
