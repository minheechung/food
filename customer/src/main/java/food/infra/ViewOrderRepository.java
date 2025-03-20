package food.infra;

import food.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "viewOrders",
    path = "viewOrders"
)
public interface ViewOrderRepository
    extends PagingAndSortingRepository<ViewOrder, Long> {}
