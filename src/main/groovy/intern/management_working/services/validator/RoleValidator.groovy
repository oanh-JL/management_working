package intern.management_working.services.validator

import intern.management_working.models.database.Role
import org.springframework.stereotype.Component

import java.time.Instant

@Component
class RoleValidator {
    void create(Role role) {
        role.setCreatedAt(Instant.now())
        role.setModifiedAt(null)
    }
}
