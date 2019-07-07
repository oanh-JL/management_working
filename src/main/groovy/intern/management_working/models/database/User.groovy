package intern.management_working.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import java.time.Instant

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "users")
class User {
    @Id
    String _id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    String userId
    String roleId
    String roleName
    @Indexed(unique = true)
    String fingerId
    String organizationId
    String fullName
    @Indexed(unique = true)
    String email
    String password
    boolean active = false
    Instant createdAt
    Instant modifiedAt
}
