package intern.management_working.services.validator

import intern.management_working.models.database.User
import intern.management_working.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserValidator {
    @Autowired
    UserRepository repository

    Boolean create(User user) {
        if (!(user.userId && user.roleId && user.fingerId && user.organizationId)) {
            throw new Exception("some fields were required")
        }
        return true
    }

    Boolean update(User user) {
        Optional<User> userFound = repository.findById(user.get_id())
        User userFoundParse = userFound.orElse(null)
        if (!userFoundParse) {
            throw new Exception("not found user for update")
        }
        return true
    }
}
