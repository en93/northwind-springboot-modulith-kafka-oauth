package en93.sample.northwindmodulith.webapp.utils;

import en93.sample.northwindmodulith.generated.webapp.model.PaginationDataDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PaginationUtil {

    /***
     * Creates response data around pagination settings used for this request
     * @param limit
     * @param offset
     * @return
     */
    public PaginationDataDTO buildPaginationResponse(Integer limit, Integer offset) {
        var pagination = new PaginationDataDTO();
        pagination.setLimit(limit);
        pagination.setOffset(offset);
        pagination.setTotal(0);
        pagination.setPageCount(0);
        return pagination;
    }

    /***
     * Offset is expected as a multiple of limit. If not will round down to make sense with page counts
     * @param limit
     * @param offset
     * @return
     */
    public Pageable buildPageRequest(Integer limit, Integer offset) {
        return PageRequest.of(offset / limit, limit);
    }

}
