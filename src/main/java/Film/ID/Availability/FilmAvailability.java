package Film.ID.Availability;

import org.json.JSONObject;

public class FilmAvailability {

    enum Country {
        AIA, ARE, ARG, ARM, ATG, AUS, AUT, AZE, BEL, BFA, BGR, BHR, BHS, BLR,
        BLZ, BMU, BOL, BRA, BRB, BRN, BWA, CAN, CHE, CHL, CHN, COL, CPV, CRI,
        CYM, CYP, CZE, DEU, DMA, DNK, DOM, ECU, EGY, ESP, EST, FIN, FJI, FRA,
        FSM, GBR, GHA, GMB, GNB, GRC, GRD, GTM, HKG, HND, HUN, IDN, IND, IRL,
        ISR, ITA, JOR, JPN, KAZ, KEN, KGZ, KHM, KNA, KOR, LAO, LBN, LKA, LTU,
        LUX, LVA, MAC, MDA, MEX, MLT, MNG, MOZ, MUS, MYS, NAM, NER, NGA, NIC,
        NLD, NOR, NPL, NZL, OMN, PAN, PER, PHL, PNG, POL, PRT, PRY, QAT, ROU,
        RUS, SAU, SGP, SLV, SVK, SVN, SWE, SWZ, THA, TJK, TKM, TTO, TUR, TWN,
        UGA, UKR, USA, UZB, VEN, VGB, VNM, ZAF, ZWE
    }

    // The name of the service.
    private String displayName;

    // The URL of the thumbnail image for the service.
    private String icon;

    // The regional store for the service. Not all countries are supported on all services.
    private Country country;

    // The unique ID (if any) for the film on this service.
    private String id;

    // The URL for the film on this service.
    private String url;

    public FilmAvailability(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        displayName = object.has("displayName") ? object.getString("displayName") : null;
        icon = object.has("icon") ? object.getString("icon") : null;

        if (object.has("country")) {
            switch (object.get("country").toString()) {
                case "AIA":
                    country = Country.AIA;
                    break;
                case "ARE":
                    country = Country.ARE;
                    break;
                case "ARG":
                    country = Country.ARG;
                    break;
                case "ARM":
                    country = Country.ARM;
                    break;
                case "ATG":
                    country = Country.ATG;
                    break;
                case "AUS":
                    country = Country.AUS;
                    break;
                case "AUT":
                    country = Country.AUT;
                    break;
                case "AZE":
                    country = Country.AZE;
                    break;
                case "BEL":
                    country = Country.BEL;
                    break;
                case "BFA":
                    country = Country.BFA;
                    break;
                case "BGR":
                    country = Country.BGR;
                    break;
                case "BHR":
                    country = Country.BHR;
                    break;
                case "BHS":
                    country = Country.BHS;
                    break;
                case "BLR":
                    country = Country.BLR;
                    break;
                case "BLZ":
                    country = Country.BLZ;
                    break;
                case "BMU":
                    country = Country.BMU;
                    break;
                case "BOL":
                    country = Country.BOL;
                    break;
                case "BRA":
                    country = Country.BRA;
                    break;
                case "BRB":
                    country = Country.BRB;
                    break;
                case "BRN":
                    country = Country.BRN;
                    break;
                case "BWA":
                    country = Country.BWA;
                    break;
                case "CAN":
                    country = Country.CAN;
                    break;
                case "CHE":
                    country = Country.CHE;
                    break;
                case "CHL":
                    country = Country.CHL;
                    break;
                case "CHN":
                    country = Country.CHN;
                    break;
                case "COL":
                    country = Country.COL;
                    break;
                case "CPV":
                    country = Country.CPV;
                    break;
                case "CRI":
                    country = Country.CRI;
                    break;
                case "CYM":
                    country = Country.CYM;
                    break;
                case "CYP":
                    country = Country.CYP;
                    break;
                case "CZE":
                    country = Country.CZE;
                    break;
                case "DEU":
                    country = Country.DEU;
                    break;
                case "DMA":
                    country = Country.DMA;
                    break;
                case "DNK":
                    country = Country.DNK;
                    break;
                case "DOM":
                    country = Country.DOM;
                    break;
                case "ECU":
                    country = Country.ECU;
                    break;
                case "EGY":
                    country = Country.EGY;
                    break;
                case "ESP":
                    country = Country.ESP;
                    break;
                case "EST":
                    country = Country.EST;
                    break;
                case "FIN":
                    country = Country.FIN;
                    break;
                case "FJI":
                    country = Country.FJI;
                    break;
                case "FRA":
                    country = Country.FRA;
                    break;
                case "FSM":
                    country = Country.FSM;
                    break;
                case "GBR":
                    country = Country.GBR;
                    break;
                case "GHA":
                    country = Country.GHA;
                    break;
                case "GMB":
                    country = Country.GMB;
                    break;
                case "GNB":
                    country = Country.GNB;
                    break;
                case "GRC":
                    country = Country.GRC;
                    break;
                case "GRD":
                    country = Country.GRD;
                    break;
                case "GTM":
                    country = Country.GTM;
                    break;
                case "HKG":
                    country = Country.HKG;
                    break;
                case "HND":
                    country = Country.HND;
                    break;
                case "HUN":
                    country = Country.HUN;
                    break;
                case "IDN":
                    country = Country.IDN;
                    break;
                case "IND":
                    country = Country.IND;
                    break;
                case "IRL":
                    country = Country.IRL;
                    break;
                case "ISR":
                    country = Country.ISR;
                    break;
                case "ITA":
                    country = Country.ITA;
                    break;
                case "JOR":
                    country = Country.JOR;
                    break;
                case "JPN":
                    country = Country.JPN;
                    break;
                case "KAZ":
                    country = Country.KAZ;
                    break;
                case "KEN":
                    country = Country.KEN;
                    break;
                case "KGZ":
                    country = Country.KGZ;
                    break;
                case "KHM":
                    country = Country.KHM;
                    break;
                case "KNA":
                    country = Country.KNA;
                    break;
                case "KOR":
                    country = Country.KOR;
                    break;
                case "LAO":
                    country = Country.LAO;
                    break;
                case "LBN":
                    country = Country.LBN;
                    break;
                case "LKA":
                    country = Country.LKA;
                    break;
                case "LTU":
                    country = Country.LTU;
                    break;
                case "LUX":
                    country = Country.LUX;
                    break;
                case "LVA":
                    country = Country.LVA;
                    break;
                case "MAC":
                    country = Country.MAC;
                    break;
                case "MDA":
                    country = Country.MDA;
                    break;
                case "MEX":
                    country = Country.MEX;
                    break;
                case "MLT":
                    country = Country.MLT;
                    break;
                case "MNG":
                    country = Country.MNG;
                    break;
                case "MOZ":
                    country = Country.MOZ;
                    break;
                case "MUS":
                    country = Country.MUS;
                    break;
                case "MYS":
                    country = Country.MYS;
                    break;
                case "NAM":
                    country = Country.NAM;
                    break;
                case "NER":
                    country = Country.NER;
                    break;
                case "NGA":
                    country = Country.NGA;
                    break;
                case "NIC":
                    country = Country.NIC;
                    break;
                case "NLD":
                    country = Country.NLD;
                    break;
                case "NOR":
                    country = Country.NOR;
                    break;
                case "NPL":
                    country = Country.NPL;
                    break;
                case "NZL":
                    country = Country.NZL;
                    break;
                case "OMN":
                    country = Country.OMN;
                    break;
                case "PAN":
                    country = Country.PAN;
                    break;
                case "PER":
                    country = Country.PER;
                    break;
                case "PHL":
                    country = Country.PHL;
                    break;
                case "PNG":
                    country = Country.PNG;
                    break;
                case "POL":
                    country = Country.POL;
                    break;
                case "PRT":
                    country = Country.PRT;
                    break;
                case "PRY":
                    country = Country.PRY;
                    break;
                case "QAT":
                    country = Country.QAT;
                    break;
                case "ROU":
                    country = Country.ROU;
                    break;
                case "RUS":
                    country = Country.RUS;
                    break;
                case "SAU":
                    country = Country.SAU;
                    break;
                case "SGP":
                    country = Country.SGP;
                    break;
                case "SLV":
                    country = Country.SLV;
                    break;
                case "SVK":
                    country = Country.SVK;
                    break;
                case "SVN":
                    country = Country.SVN;
                    break;
                case "SWE":
                    country = Country.SWE;
                    break;
                case "SWZ":
                    country = Country.SWZ;
                    break;
                case "THA":
                    country = Country.THA;
                    break;
                case "TJK":
                    country = Country.TJK;
                    break;
                case "TKM":
                    country = Country.TKM;
                    break;
                case "TTO":
                    country = Country.TTO;
                    break;
                case "TUR":
                    country = Country.TUR;
                    break;
                case "TWN":
                    country = Country.TWN;
                    break;
                case "UGA":
                    country = Country.UGA;
                    break;
                case "UKR":
                    country = Country.UKR;
                    break;
                case "USA":
                    country = Country.USA;
                    break;
                case "UZB":
                    country = Country.UZB;
                    break;
                case "VEN":
                    country = Country.VEN;
                    break;
                case "VGB":
                    country = Country.VGB;
                    break;
                case "VNM":
                    country = Country.VNM;
                    break;
                case "ZAF":
                    country = Country.ZAF;
                    break;
                case "ZWE":
                    country = Country.ZWE;
                    break;
                default:
                    country = null;
            }
        }

        id = object.has("id") ? object.getString("id") : null;
        url = object.has("url") ? object.getString("url") : null;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getIcon() {
        return icon;
    }

    public Country getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
