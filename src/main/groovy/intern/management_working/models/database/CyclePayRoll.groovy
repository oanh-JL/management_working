package intern.management_working.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id

import java.time.Instant

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
class CyclePayRoll {

    @Id
    String _id
    String userId
    float totalDay
    float totalTime
    Instant dayFrom
    Instant dayTo
    Instant createdAt
    Instant modifiedAt
}
