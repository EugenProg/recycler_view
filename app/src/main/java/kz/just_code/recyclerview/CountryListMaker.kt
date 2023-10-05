package kz.just_code.recyclerview

import android.content.Context

object CountryListMaker {
    private val stringList = mutableListOf(
        R.string.AB, R.string.AU, R.string.AT, R.string.AZ, R.string.AL, R.string.DZ, R.string.AS,
        R.string.AI, R.string.AO, R.string.AD, R.string.AR, R.string.AG, R.string.AM, R.string.AW,
        R.string.AF, R.string.BS, R.string.BD, R.string.BB, R.string.BH, R.string.BY, R.string.BZ,
        R.string.BE, R.string.BJ, R.string.BM, R.string.BG, R.string.BO, R.string.BQ, R.string.BA,
        R.string.BW, R.string.BR, R.string.IO, R.string.BN, R.string.BF, R.string.BI, R.string.BT,
        R.string.VU, R.string.HU, R.string.VE, R.string.VG, R.string.VI, R.string.VN, R.string.GA,
        R.string.HT, R.string.GY, R.string.GM, R.string.GH, R.string.GP, R.string.GT, R.string.GN,
        R.string.GW, R.string.DE, R.string.GG, R.string.GI, R.string.HN, R.string.HK, R.string.GD,
        R.string.GL, R.string.GR, R.string.GE, R.string.GU, R.string.DK, R.string.JE, R.string.DJ,
        R.string.DM, R.string.DO, R.string.EG, R.string.ZM, R.string.EH, R.string.ZW, R.string.IL,
        R.string.IN, R.string.ID, R.string.JO, R.string.IQ, R.string.IE, R.string.IS, R.string.ES,
        R.string.IT, R.string.YE, R.string.CV, R.string.KZ, R.string.KH, R.string.CM, R.string.CA,
        R.string.QA, R.string.KE, R.string.CY, R.string.KG, R.string.KI, R.string.CN, R.string.CC,
        R.string.CO, R.string.KM, R.string.CG, R.string.CD, R.string.KP, R.string.KR, R.string.CR,
        R.string.CI, R.string.CU, R.string.KW, R.string.CW, R.string.LA, R.string.LV, R.string.LS,
        R.string.LB, R.string.LY, R.string.LR, R.string.LI, R.string.LT, R.string.LU, R.string.MU,
        R.string.MR, R.string.MG, R.string.YT, R.string.MO, R.string.MW, R.string.MY, R.string.ML,
        R.string.UM, R.string.MV, R.string.MT, R.string.MA, R.string.MQ, R.string.MH, R.string.MX,
        R.string.FM, R.string.MZ, R.string.MD, R.string.MC, R.string.MN, R.string.MS, R.string.MM,
        R.string.NA, R.string.NR, R.string.NP, R.string.NE, R.string.NG, R.string.NL, R.string.NI,
        R.string.NU, R.string.NZ, R.string.NC, R.string.NO, R.string.AE, R.string.OM, R.string.BV,
        R.string.IM, R.string.NF, R.string.CX, R.string.HM, R.string.KY, R.string.CK, R.string.TC,
        R.string.PK, R.string.PW, R.string.PA, R.string.VA, R.string.PG, R.string.PY, R.string.PE,
        R.string.PN, R.string.PL, R.string.PT, R.string.PR, R.string.MK, R.string.RE, R.string.RU,
        R.string.RW, R.string.RO, R.string.WS, R.string.SM, R.string.ST, R.string.SA, R.string.SH,
        R.string.MP, R.string.BL, R.string.MF, R.string.SN, R.string.VC, R.string.KN, R.string.LC,
        R.string.PM, R.string.RS, R.string.SC, R.string.SG, R.string.SX, R.string.SY, R.string.SK,
        R.string.SI, R.string.GB, R.string.US, R.string.SB, R.string.SO, R.string.SD, R.string.SR,
        R.string.SL, R.string.TJ, R.string.TH, R.string.TW, R.string.TZ, R.string.TL, R.string.TG,
        R.string.TK, R.string.TO, R.string.TT, R.string.TV, R.string.TN, R.string.TM, R.string.TR,
        R.string.UG, R.string.UZ, R.string.UA, R.string.WF, R.string.WF, R.string.UY, R.string.FO,
        R.string.FJ, R.string.PH, R.string.FI, R.string.FK, R.string.FR, R.string.GF, R.string.PF,
        R.string.TF, R.string.HR, R.string.CF, R.string.TD, R.string.ME, R.string.CZ, R.string.CL,
        R.string.CH, R.string.SE, R.string.SJ, R.string.LK, R.string.EC, R.string.GQ, R.string.AX,
        R.string.SV, R.string.ER, R.string.SZ, R.string.EE, R.string.ET, R.string.ZA, R.string.GS,
        R.string.OS, R.string.SS, R.string.JM, R.string.JP
    )

    fun getCountryList(context: Context): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        stringList.forEach {
            list.add(context.getString(it))
        }

        return list
    }
}