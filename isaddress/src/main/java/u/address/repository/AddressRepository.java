package u.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import u.address.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
