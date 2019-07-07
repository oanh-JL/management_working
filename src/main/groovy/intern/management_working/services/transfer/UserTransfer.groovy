package intern.management_working.services.transfer

import intern.management_working.models.database.User
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class UserTransfer {
    static void create(User user) {
        user.setCreatedAt(LocalDate.now())
        user.setModifiedAt(null)
    }

    static void update(User user) {
        user.setCreatedAt(LocalDate.parse(user.getCreatedAt().toString()))
        user.setModifiedAt(LocalDate.parse(user.getCreatedAt().toString()))
    }
}
