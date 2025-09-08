package en93.sample.northwindmodulith.webapp.utils;

import en93.sample.northwindmodulith.generated.webapp.model.OrderDTO;
import en93.sample.northwindmodulith.generated.webapp.model.PaginationDataDTO;
import en93.sample.northwindmodulith.generated.webapp.model.SortDirectionEnumDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PaginationUtil {

    /***
     * Creates response data around pagination settings used for this request
     * @param limit
     * @param offset
     * @return
     */
//    public PaginationDataDTO buildPaginationResponse(Integer limit, Integer offset) {
//        var pagination = new PaginationDataDTO();
//        pagination.setLimit(limit);
//        pagination.setOffset(offset);
//        pagination.setTotal(0);
//        pagination.setPageCount(0);
//        return pagination;
//    }

    /***
     * Offset is expected as a multiple of limit. If not will round down to make sense with page counts
     * @param limit
     * @param offset
     * @return
     */
    public Pageable buildPageRequest(Integer limit, Integer offset, String sortField, SortDirectionEnumDTO sortDirection) {
        var page = offset / limit;
        if (sortField != null) {
            var direction = sortDirection != null ? Sort.Direction.fromString(sortDirection.getValue()) : Sort.Direction.ASC;
            return PageRequest.of(page, limit).withSort(direction, sortField);
        }
        return PageRequest.of(page, limit);
    }

    //todo, change to cursor based pagination?
    public <T> PaginationDataDTO buildPaginationResponse(Page<T> orders) {
        var pagination = new PaginationDataDTO();
        pagination.setSize(orders.getSize());
        pagination.setPageCount(orders.getTotalPages());
        pagination.setPageCurrent(orders.getNumber());
        pagination.setTotalElements(Long.valueOf(orders.getTotalElements()).intValue());
        return pagination;

    }
}
