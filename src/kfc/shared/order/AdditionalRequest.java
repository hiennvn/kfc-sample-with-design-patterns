package kfc.shared.order;

/**
 *
 * @author hien
 */

public class AdditionalRequest {
    private RequestType requestType;
    private String requestDetail;
    
    public AdditionalRequest(RequestType requestType, String requestDetail) {
        this.requestType = requestType;
        this.requestDetail = requestDetail;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public String getRequestDetail() {
        return requestDetail;
    }

    public void setRequestDetail(String requestDetail) {
        this.requestDetail = requestDetail;
    }
}



