package intern.management_working.repositories

import intern.management_working.models.database.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "?0")
    Page<User> findAllPagingUser(Pageable pageable)
    Optional<User> findByUserId(String userId)
}
