package me.ykrank.s1next.data.api;

/**
 * Created by ykrank on 2017/1/4.
 */

public class ApiHome {

    static final String URL_FAVOURITES = Api.BASE_API_PREFIX + "myfavthread";

    //PM
    static final String URL_PM_LIST = Api.BASE_API_PREFIX + "mypm&filter=privatepm";
    static final String URL_ANNOUNCE_PM_LIST = Api.BASE_API_PREFIX + "mypm&filter=announcepm";
    static final String URL_PM_VIEW_LIST = Api.BASE_API_PREFIX + "mypm&subop=view";
    static final String URL_PM_POST = Api.BASE_API_PREFIX + "sendpm&pmsubmit=true";

    //Favourites
    static final String URL_THREAD_FAVOURITES_ADD = Api.BASE_API_PREFIX + "favthread&favoritesubmit=yes";
    static final String URL_THREAD_FAVOURITES_REMOVE = Api.BASE_API_PREFIX + "favthread&deletesubmit=true&op=delete";

    //Notes
    static final String URL_MY_NOTE_LIST = Api.BASE_API_PREFIX + "mynotelist&view=mypost&type=post&version=3";

    //Profile
    static final String URL_PROFILE = Api.BASE_API_PREFIX + "profile";
    static final String URL_PROFILE_WEB = Api.BASE_URL + "home.php?mod=space&do=profile&from=space";

    //Friends
    static final String URL_FRIENDS = Api.BASE_API_PREFIX + "friend";

    //Threads
    static final String URL_THREADS = Api.BASE_URL + "home.php?mod=space&do=thread&from=space&type=thread&view=me";

    //Replies
    static final String URL_REPLIES = Api.BASE_URL + "home.php?mod=space&do=thread&from=space&type=reply&view=me";

    //Rate
    static final String URL_RATE_PRE = Api.BASE_URL + "forum.php?mod=misc&action=rate&infloat=yes&handlekey=rate&inajax=1&ajaxtarget=fwin_content_rate";
    static final String URL_RATE = Api.BASE_URL + "forum.php?mod=misc&action=rate&ratesubmit=yes&infloat=yes&inajax=1";

    //Report
    static final String URL_REPORT_PRE = Api.BASE_URL + "misc.php?mod=report&rtype=post&rid=41759641&tid=1793919&t=1543462376208&inajax=1";
    static final String URL_REPORT = Api.BASE_URL + "misc.php?mod=report&inajax=1";
}
