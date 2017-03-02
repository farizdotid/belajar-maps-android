package meridianid.farizdotid.belajarmaps.helper.direction;

import java.util.List;

/**
 * Created by farizdotid.
 * www.farizdotid.com
 */

public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
