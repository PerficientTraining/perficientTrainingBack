package perficient.com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import perficient.com.model.Group;

public interface IGroupRepository extends JpaRepository <Group, Integer> {
}
