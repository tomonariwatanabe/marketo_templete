#*
Build utm_parameter
The parameter comented is using mytoken
*#
#set($utm_campaign = "mkt_other")
#set($utm_medium = "mkt_dy_mail")
#set($utm_content = "browsing_bukken_ranking")

#*
Add multiple array using an image link on marketo image
*#
#set( $bukken_ranking_img =
[{
"ranking_crown_img_url":"{%image.01_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_gold_2202%}"
},{
"ranking_crown_img_url":"{%image.02_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_silver_2202%}"
},{
"ranking_crown_img_url":"{%image.03_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_bronze_2202%}"
},{
"ranking_crown_img_url":"{%image.04_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_base_2202%}"
},{
"ranking_crown_img_url":"{%image.05_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_base_2202%}"
}])

#*
Set staff_id Parameter
*#
#if($lead.userEmailAccountName.length() > 0)
#set($staff_id_param = "&staff_id=${lead.userEmailAccountName}")
#else
#set($staff_id_param = "")
#end

#*
Set link from custome object data on marketo
*#
#foreach($object in $view_req_ranking_top5List)
#if($object.mail_key.contains('browsing_bukken_ranking_in_7days'))
#set( $defaultTimeZone = $date.getTimeZone().getTimeZone("Asia/Tokyo") )
#set( $defaultLocale = $date.getLocale() )
#set( $calNow = $date.getCalendar() )
#set( $ret = $calNow.setTimeZone($defaultTimeZone) )
#set( $calConst = $field.in($calNow) )
#set( $ISO8601DateOnly = "yyyy-MM-dd" )
#set( $nowData_YYYYMMDD = $date.format($ISO8601DateOnly,$calNow,$defaultLocale,$defaultTimeZone) )
#set($y = ${convert.parseDate($nowData_YYYYMMDD, 'yyyy-MM-dd')})
#set($x = ${convert.parseDate($object.effect_date, 'yyyy-MM-dd')})
#if($date.whenIs($x,$y).days == 0)
#foreach ($i in [1..5])
#set ($bukken_url = "${esc.d}object.bukken_url_${i}")
#set($bukken_base_url = "#evaluate($bukken_url)")
#set($bukken_id = $bukken_base_url.replaceAll("oh.openhouse-group.com.*?\/(.*)/(.*)/(.*)\/", "$3"))
#set($bukken_area = $bukken_base_url.replaceAll("oh.openhouse-group.com.*?\/(.*)/(.*)/(.*)\/", "$1"))


#evaluate( "${esc.h}set( ${esc.d}bukken_area_${i} = ${esc.d}bukken_area )" )
#evaluate( "${esc.h}set( ${esc.d}bukken_id_${i} = ${esc.d}bukken_id)" )
#evaluate( "${esc.h}set( ${esc.d}utm_term_${i} = ${esc.d}i )" )
#end
#end
#end
#end

#set($count_num = 1)

#*
Set data from custome object data on marketo
*#
#foreach($object in $view_req_ranking_top5List)
#if($object.mail_key.contains('browsing_bukken_ranking_in_7days'))
#set( $defaultTimeZone = $date.getTimeZone().getTimeZone("Asia/Tokyo") )
#set( $defaultLocale = $date.getLocale() )
#set( $calNow = $date.getCalendar() )
#set( $ret = $calNow.setTimeZone($defaultTimeZone) )
#set( $calConst = $field.in($calNow) )
#set( $ISO8601DateOnly = "yyyy-MM-dd" )
#set( $nowData_YYYYMMDD = $date.format($ISO8601DateOnly,$calNow,$defaultLocale,$defaultTimeZone) )
#set($y = ${convert.parseDate($nowData_YYYYMMDD, 'yyyy-MM-dd')})
#set($x = ${convert.parseDate($object.effect_date, 'yyyy-MM-dd')})
#if($date.whenIs($x,$y).days == 0)
#foreach ($i in [1..5])
#set ($bukken_img_url = "${esc.d}object.bukken_img_url_${i}")

#set ($full_address = "${esc.d}object.full_address_${i}")
#set ($price = "${esc.d}object.price_${i}")
#set ($title = "${esc.d}object.title_${i}")
#set ($free_catch = "${esc.d}object.free_catch_${i}")
#set ($station_access = "${esc.d}object.station_access_${i}")
#set($j = $i - 1)
#set($ranking_crown_img_url = $bukken_ranking_img[$j].ranking_crown_img_url)
#set($ranking_line_img_url = $bukken_ranking_img[$j].ranking_line_img_url)


#set($title = "#evaluate($title)")
#set($free_catch = "#evaluate($free_catch)")
#set($price = "#evaluate($price)")
#set($full_address = "#evaluate($full_address)")
#set($bukken_img_url = "#evaluate($bukken_img_url)")
#set($station_access = "#evaluate($station_access)")


#set( $defaultTimeZone = $date.getTimeZone().getTimeZone("Asia/Tokyo") )
#set( $defaultLocale = $date.getLocale() )
#set( $calNow = $date.getCalendar() )
#set( $ret = $calNow.setTimeZone($defaultTimeZone) )
#set( $calConst = $field.in($calNow) )
#set( $ISO8601DateOnly = "yyyy-MM-dd" )
#set( $yyyymmdd = "yyyyMMdd" )
#set( $nowData_YYYYMMDD = $date.format($ISO8601DateOnly,$calNow,$defaultLocale,$defaultTimeZone) )
#set( $banner_id = $date.format($yyyymmdd,$calNow,$defaultLocale,$defaultTimeZone) )
#if( $i == 1 )
#if ((!$object.bukken_url_1) && ("$!object.bukken_url_1" == ""))
#else
<!-- START ランキング物件 -->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellspacing="0" cellpadding="12px" border="0" width="100%" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:white;">
    <tbody>
        <tr>
            <td>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellpadding="0" cellspacing="0" border="0" align="center" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:#FFFEF8;padding:0 11%">
    <tbody>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;">
                <img width="100%" alt="第$i位" src="$ranking_crown_img_url">
            </td>
        </tr>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;background-color:#FFFEF8;">
                <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:80%;max-width: 480px;">
                    <tbody>
                        <tr>
                            <td>
                            <a href="https://oh.openhouse-group.com/${bukken_area_1}/bukken/${bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param">
                            <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFEF8;color:#215EAF;text-align: center;font-weight: 900;">$title</p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 15px;mso-ansi-font-size:15px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: left;font-weight: 700;">$free_catch</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>

                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: center;">$full_address<br>$station_access<br>$price</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>

                        <tr style="table-layout:fixed">
                            <td style="width: 50%;display: inline-table;">
                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                            <td style="width: 50%;display: inline-table;">
                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding:10px;width:100%;">
                            <a href="https://oh.openhouse-group.com/${bukken_area_1}/bukken/${bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param">
                            <img width="100%" src="https://$bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px;">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                <w:anchorlock/>
                                <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                        <tr>
                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;" valign="top">
                                <table class="table600" style="-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-spacing: 0; border-collapse: collapse; margin-top: 0; margin-right: auto; margin-bottom: 0; margin-left: auto;" align="center" border="0" cellpadding="0" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;display: block;" height="8px">&nbsp;</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_1}/bukken/${bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                <w:anchorlock/>
                                <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_1}/bukken/${bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>

    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!-- END ランキング物件 -->
#set($count_num = $count_num + 1)
#end
#elseif($i == 2)
#if ((!$object.bukken_url_2) && ("$!object.bukken_url_2" == ""))
#else
<!-- START ランキング物件 -->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellspacing="0" cellpadding="12px" border="0" width="100%" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:white;">
    <tbody>
        <tr>
            <td>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellpadding="0" cellspacing="0" border="0" align="center" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:#FFFEF8;padding:0 11%">
    <tbody>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;">
                <img width="100%" alt="第$i位" src="$ranking_crown_img_url">
            </td>
        </tr>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;background-color:#FFFEF8;">
                <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:80%;max-width: 480px;">
                    <tbody>
                        <tr>
                            <td>
                            <a href="https://oh.openhouse-group.com/${bukken_area_2}/bukken/${bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param">
                            <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFEF8;color:#215EAF;text-align: center;font-weight: 900;">$title</p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 15px;mso-ansi-font-size:15px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: left;font-weight: 700;">$free_catch</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>

                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: center;">$full_address<br>$station_access<br>$price</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>

                        <tr style="table-layout:fixed">
                            <td style="width: 50%;display: inline-table;">
                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                            <td style="width: 50%;display: inline-table;">
                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding:10px;width:100%;">
                            <a href="https://oh.openhouse-group.com/${bukken_area_2}/bukken/${bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param">
                            <img width="100%" src="https://$bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px;">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                <w:anchorlock/>
                                <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                        <tr>
                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;" valign="top">
                                <table class="table600" style="-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-spacing: 0; border-collapse: collapse; margin-top: 0; margin-right: auto; margin-bottom: 0; margin-left: auto;" align="center" border="0" cellpadding="0" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;display: block;" height="8px">&nbsp;</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_2}/bukken/${bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                <w:anchorlock/>
                                <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_2}/bukken/${bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>

    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!-- END ランキング物件 -->
#set($count_num = $count_num + 1)
#end
#elseif($i == 3)
#if ((!$object.bukken_url_3) && ("$!object.bukken_url_3" == ""))
#else
<!-- START ランキング物件 -->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellspacing="0" cellpadding="12px" border="0" width="100%" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:white;">
    <tbody>
        <tr>
            <td>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellpadding="0" cellspacing="0" border="0" align="center" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:#FFFEF8;padding:0 11%">
    <tbody>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;">
                <img width="100%" alt="第$i位" src="$ranking_crown_img_url">
            </td>
        </tr>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;background-color:#FFFEF8;">
                <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:80%;max-width: 480px;">
                    <tbody>
                        <tr>
                            <td>
                            <a href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param">
                            <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFEF8;color:#215EAF;text-align: center;font-weight: 900;">$title</p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 15px;mso-ansi-font-size:15px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: left;font-weight: 700;">$free_catch</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>

                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: center;">$full_address<br>$station_access<br>$price</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>

                        <tr style="table-layout:fixed">
                            <td style="width: 50%;display: inline-table;">
                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                            <td style="width: 50%;display: inline-table;">
                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding:10px;width:100%;">
                            <a href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param">
                            <img width="100%" src="https://$bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px;">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                <w:anchorlock/>
                                <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                        <tr>
                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;" valign="top">
                                <table class="table600" style="-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-spacing: 0; border-collapse: collapse; margin-top: 0; margin-right: auto; margin-bottom: 0; margin-left: auto;" align="center" border="0" cellpadding="0" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;display: block;" height="8px">&nbsp;</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                <w:anchorlock/>
                                <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>

    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!-- END ランキング物件 -->
#set($count_num = $count_num + 1)
#end
#elseif($i == 4)
#if ((!$object.bukken_url_4) && ("$!object.bukken_url_4" == ""))
#else
<!-- START ランキング物件 -->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellspacing="0" cellpadding="12px" border="0" width="100%" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:white;">
    <tbody>
        <tr>
            <td>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellpadding="0" cellspacing="0" border="0" align="center" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:#FFFEF8;padding:0 11%">
    <tbody>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;">
                <img width="100%" alt="第$i位" src="$ranking_crown_img_url">
            </td>
        </tr>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;background-color:#FFFEF8;">
                <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:80%;max-width: 480px;">
                    <tbody>
                        <tr>
                            <td>
                            <a href="https://oh.openhouse-group.com/${bukken_area_4}/bukken/${bukken_id_4}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param">
                            <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFEF8;color:#215EAF;text-align: center;font-weight: 900;">$title</p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 15px;mso-ansi-font-size:15px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: left;font-weight: 700;">$free_catch</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>

                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: center;">$full_address<br>$station_access<br>$price</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>

                        <tr style="table-layout:fixed">
                            <td style="width: 50%;display: inline-table;">
                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_4}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                            <td style="width: 50%;display: inline-table;">
                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_4}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding:10px;width:100%;">
                            <a href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_4}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param">
                            <img width="100%" src="https://$bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px;">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_4}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                <w:anchorlock/>
                                <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_4}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                        <tr>
                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;" valign="top">
                                <table class="table600" style="-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-spacing: 0; border-collapse: collapse; margin-top: 0; margin-right: auto; margin-bottom: 0; margin-left: auto;" align="center" border="0" cellpadding="0" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;display: block;" height="8px">&nbsp;</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_4}/bukken/${bukken_id_4}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                <w:anchorlock/>
                                <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_4}/bukken/${bukken_id_4}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>

    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!-- END ランキング物件 -->
#set($count_num = $count_num + 1)
#end
#elseif($i == 5)
#if ((!$object.bukken_url_5) && ("$!object.bukken_url_5" == ""))
#else
<!-- START ランキング物件 -->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellspacing="0" cellpadding="12px" border="0" width="100%" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:white;">
    <tbody>
        <tr>
            <td>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellpadding="0" cellspacing="0" border="0" align="center" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:#FFFEF8;padding:0 11%">
    <tbody>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;">
                <img width="100%" alt="第$i位" src="$ranking_crown_img_url">
            </td>
        </tr>
        <tr style="max-width: 600px;width:100%">
            <td style="padding:0;background-color:#FFFEF8;">
                <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:80%;max-width: 480px;">
                    <tbody>
                        <tr>
                            <td>
                            <a href="https://oh.openhouse-group.com/${bukken_area_5}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param">
                            <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFEF8;color:#215EAF;text-align: center;font-weight: 900;">$title</p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 15px;mso-ansi-font-size:15px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: left;font-weight: 700;">$free_catch</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>

                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: center;">$full_address<br>$station_access<br>$price</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>

                        <tr style="table-layout:fixed">
                        <td class="left_btn" style="width: 46%;display: inline-table;margin-left: 4%;">
                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_5}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                            <td class="left_btn" style="width: 46%;display: inline-table;margin-left: 4%;">
                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_5}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                            <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding:10px;width:100%;">
                            <a href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param">
                            <img width="100%" src="https://$bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px;">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_5}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                <w:anchorlock/>
                                <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_5}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                        <tr>
                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;" valign="top">
                                <table class="table600" style="-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-spacing: 0; border-collapse: collapse; margin-top: 0; margin-right: auto; margin-bottom: 0; margin-left: auto;" align="center" border="0" cellpadding="0" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;display: block;" height="8px">&nbsp;</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px">
                            <!--[if gte mso | IE]>
                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_5}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                <w:anchorlock/>
                                <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                            </v:roundrect>
                            <![endif]-->
                                        <!--[if !gte !mso | !IE]><!-- -->
                                        <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_5}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                        <!--<![endif]-->
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>

    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!-- END ランキング物件 -->
#set($count_num = $count_num + 1)
#end
#end
#end
#end
#end
#end