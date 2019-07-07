package intern.management_working.models.database

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

import java.time.Instant

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(collection = "time_sheets")
class TimeSheet {
    @Id
    String _id
    String userId
    String totalTime
    @DBRef
    RawDaily rawDailyId
    int status
    Instant createdAt
    Instant modifiedAt
}
