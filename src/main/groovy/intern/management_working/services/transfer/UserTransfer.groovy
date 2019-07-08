package intern.management_working.services.transfer

import intern.management_working.models.database.User
import org.springframework.stereotype.Component

import java.time.Instant

@Component
class UserTransfer {
    static void create(User user) {
        user.setCreatedAt(Instant.now())
        user.setModifiedAt(null)
    }

    static void update(User user) {
        user.setCreatedAt(Instant.parse(user.getCreatedAt().toString()))
        user.setModifiedAt(Instant.parse(user.getCreatedAt().toString()))
    }
}
