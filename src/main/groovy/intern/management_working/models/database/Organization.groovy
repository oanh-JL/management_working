package intern.management_working.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

import java.time.Instant

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "organizations")
class Organization {
    @Id
    String _id
    @Indexed(unique = true)
    String organizationId
    String managerId
    String nameOrganization
    @DBRef
    Organization parentOrganization
    String description
    Instant createdAt
    Instant modifiedAt

}
