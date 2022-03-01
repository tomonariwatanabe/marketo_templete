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
"ranking_line_img_url":"{%image.dotted_line_gold_2202%}",
"ranking_border_line_color":"#e5c464",
"line_title":"{%image.railwey_name_gold_2202%}",
"station_title":"{%image.station_name_gold_2202%}"
},{
"ranking_crown_img_url":"{%image.02_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_silver_2202%}",
"ranking_border_line_color":"#B2B2B2",
"line_title":"{%image.railwey_name_silver_2202%}",
"station_title":"{%image.station_name_silver_2202%}"
},{
"ranking_crown_img_url":"{%image.03_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_bronze_2202%}",
"ranking_border_line_color":"#A07668",
"line_title":"{%image.railwey_name_bronze_2202%}",
"station_title":"{%image.station_name_bronze_2202%}"
},{
"ranking_crown_img_url":"{%image.04_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_base_2202%}",
"ranking_border_line_color":"#7C96B1",
"line_title":"{%image.railwey_name_base_2202%}",
"station_title":"{%image.station_name_base_2202%}"
},{
"ranking_crown_img_url":"{%image.05_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_base_2202%}",
"ranking_border_line_color":"#7C96B1",
"line_title":"{%image.railwey_name_base_2202%}",
"station_title":"{%image.station_name_base_2202%}"
},{
"ranking_crown_img_url":"{%image.06_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_base_2202%}",
"ranking_border_line_color":"#7C96B1",
"line_title":"{%image.railwey_name_base_2202%}",
"station_title":"{%image.station_name_base_2202%}"
},{
"ranking_crown_img_url":"{%image.07_rank_crown_2202%}",
"ranking_line_img_url":"{%image.dotted_line_base_2202%}",
"ranking_border_line_color":"#7C96B1",
"line_title":"{%image.railwey_name_base_2202%}",
"station_title":"{%image.station_name_base_2202%}"
}])

#if($lead.userEmailAccountName.length() > 0)
#set($staff_id_param = "&staff_id=${lead.userEmailAccountName}")
#else
#set($staff_id_param = "")
#end

#*
Set link from custome object data on marketo
*#
#foreach($object in $ensen_eki_view_req_ranking_top7List)
#if($object.mail_key.contains('ensen_eki_browsing_ranking_in_7days'))
#foreach ($i in [1..7])

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
#set ($eki_search_url= "${esc.d}object.eki_search_url_${i}")
#set ($ensen_search_url= "${esc.d}object.ensen_search_url_${i}")

#evaluate( "${esc.h}set( ${esc.d}$eki_search_url_${i} = ${esc.d}$eki_search_url )" )
#evaluate( "${esc.h}set( ${esc.d}$ensen_search_url_${i} = ${esc.d}$ensen_search_url)" )
#evaluate( "${esc.h}set( ${esc.d}utm_term_${i} = ${esc.d}i )" )
#end
#end
#end
#end


#*
Set data from custome object data on marketo
*#

#foreach($object in $ensen_eki_view_req_ranking_top7List)
#if($object.mail_key.contains('ensen_eki_browsing_ranking_in_7days'))
#foreach ($i in [1..7])

#set ($ensen_name = "${esc.d}object.ensen_name_${i}")
#set ($eki_name = "${esc.d}object.eki_name_${i}")

#set($ensen_name = "#evaluate($ensen_name)")
#set($eki_name = "#evaluate($eki_name)")


#set($j = $i - 1)
#set($ranking_crown_img_url = $bukken_ranking_img[$j].ranking_crown_img_url)
#set($ranking_line_img_url = $bukken_ranking_img[$j].ranking_line_img_url)
#set($ranking_border_line_color = $bukken_ranking_img[$j].ranking_border_line_color)
#set($line_title = $bukken_ranking_img[$j].line_title)
#set($station_title = $bukken_ranking_img[$j].station_title)

#set( $defaultTimeZone = $date.getTimeZone().getTimeZone("Asia/Tokyo") )
#set( $defaultLocale = $date.getLocale() )
#set( $calNow = $date.getCalendar() )
#set( $ret = $calNow.setTimeZone($defaultTimeZone) )
#set( $calConst = $field.in($calNow) )
#set( $ISO8601DateOnly = "yyyy-MM-dd" )
#set( $yyyymmdd = "yyyyMMdd" )
#set( $nowData_YYYYMMDD = $date.format($ISO8601DateOnly,$calNow,$defaultLocale,$defaultTimeZone) )
#set( $banner_id = $date.format($yyyymmdd,$calNow,$defaultLocale,$defaultTimeZone) )
#set($y = ${convert.parseDate($nowData_YYYYMMDD, 'yyyy-MM-dd')})
#set($x = ${convert.parseDate($object.effect_date, 'yyyy-MM-dd')})

#if($date.whenIs($x,$y).days == 0)
<!-- START ランキング -->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellpadding="0" cellspacing="0" border="0" align="center" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:#fbf8eb;padding:0 11%">
    <tbody>
        <tr style="max-width:600px;width:100%">
            <td style="padding:12px;background-color:#fbf8eb;">
            </td>
        </tr>
        <tr style="max-width:600px;width:100%">
            <td style="padding:0;">
                <img width="100%" alt="第$i位" src="$ranking_crown_img_url">
            </td>
        </tr>
        <tr style="max-width:600px;width:100%">
            <td style="padding:0;">
                <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: separate !important;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:80%;max-width: 480px;">
                    <tbody>
                        <tr width="100">
                            <td>
                                <table cellspacing="0" cellpadding="12px" border="0" width="100%" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;">
                                    <tr>
                                        <td></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="$line_title" alt="沿線名">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="background-color: #FFFFFF;">
                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFFFF;color:#000000;text-align: center;font-weight: 700;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;margin: 0;padding: 1em 0;">$ensen_name</p>

                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_colorborder-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                #if( $i == 1 )
                                <p style="margin:0;padding-bottom: 1.5em;background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${ensen_search_url_1}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${ensen_search_url_1}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 2 )
                                <p style="margin:0;padding-bottom: 1.5em;background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${ensen_search_url_2}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${ensen_search_url_2}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 3 )
                                <p style="margin:0;padding-bottom: 1.5em;background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${ensen_search_url_3}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${ensen_search_url_3}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 4 )
                                <p style="margin:0;padding-bottom: 1.5em;background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${ensen_search_url_4}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${ensen_search_url_4}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 5 )
                                <p style="margin:0;padding-bottom: 1.5em;background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${ensen_search_url_5}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${ensen_search_url_5}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 6 )
                                <p style="margin:0;padding-bottom: 1.5em;background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${ensen_search_url_6}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_6}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${ensen_search_url_6}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_6}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 7 )
                                <p style="margin:0;padding-bottom: 1.5em;background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${ensen_search_url_7}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_7}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${ensen_search_url_7}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=line_0${utm_term_7}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="$station_title" alt="駅名">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="background-color: #FFFFFF;">
                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFFFF;color:#000000;text-align: center;font-weight: 700;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;margin: 0;padding: 1em 0;">#evaluate($eki_name)</p>

                            </td>
                        </tr>

                        <!-- ボタンをテキストにする場合 -->
                        <tr>
                            <td align="center" style="background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_color;border-right: solid 1px $ranking_border_line_color;border-bottom: solid 1px $ranking_border_line_color;border-radius:0px 0px 3px 3px;">
                                #if( $i == 1 )
                                <p style="margin:0;padding-bottom: 1.5em;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${eki_search_url_1}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${eki_search_url_1}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 2 )
                                <p style="margin:0;padding-bottom: 1.5em;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${eki_search_url_2}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${eki_search_url_2}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 3 )
                                <p style="margin:0;padding-bottom: 1.5em;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${eki_search_url_3}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${eki_search_url_3}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 4 )
                                <p style="margin:0;padding-bottom: 1.5em;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${eki_search_url_4}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${eki_search_url_4}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 5 )
                                <p style="margin:0;padding-bottom: 1.5em;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${eki_search_url_5}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${eki_search_url_5}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 6 )
                                <p style="margin:0;padding-bottom: 1.5em;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${eki_search_url_6}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_6}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${eki_search_url_6}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_6}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                                #if( $i == 7 )
                                <p style="margin:0;padding-bottom: 1.5em;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://${eki_search_url_7}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_7}&banner_id=${banner_id}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">物件を見る ＞</center>
                                    </v:roundrect>
                                <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="https://${eki_search_url_7}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=station_0${utm_term_7}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
                                #end
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        <tr width="100">
            <td>
                <table cellspacing="0" cellpadding="12px" border="0" width="100%" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;">
                    <tr>
                        <td></td>
                    </tr>
                </table>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!-- END ランキング -->
#end
#end
#end
#end