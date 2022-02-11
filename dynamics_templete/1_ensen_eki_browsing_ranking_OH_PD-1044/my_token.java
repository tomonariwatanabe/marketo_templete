#*
Add multiple array using an image link on marketo image
*#
#set( $bukken_ranking_img =
[{
"ranking_crown_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1.png",
"ranking_line_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png",
"ranking_border_line_color":"#e5c464",
"line_title":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_little_title.png",
"station_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_station_title.png"
},{
"ranking_crown_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/2.png",
"ranking_line_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/2_line.png",
"ranking_border_line_color":"#B2B2B2",
"line_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/2_little_title.png",
"station_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/2_station_title.png"
},{
"ranking_crown_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/3.png",
"ranking_line_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/3_line.png",
"ranking_border_line_color":"#A07668",
"line_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/3_little_title.png",
"station_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/3_station_title.png"
},{
"ranking_crown_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/4.png",
"ranking_line_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/4_line.png",
"ranking_border_line_color":"#7C96B1",
"line_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/0_little_title.png",
"station_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/0_station_title.png"
},{
"ranking_crown_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/5.png",
"ranking_line_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/5_line.png",
"ranking_border_line_color":"#7C96B1",
"line_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/0_little_title.png",
"station_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/0_station_title.png"
},{
"ranking_crown_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/6.png",
"ranking_line_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/6_line.png",
"ranking_border_line_color":"#7C96B1",
"line_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/0_little_title.png",
"station_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/0_station_title.png"
},{
"ranking_crown_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/7.png",
"ranking_line_img_url":"https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/7_line.png",
"ranking_border_line_color":"#7C96B1",
"line_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/0_little_title.png",
"station_title":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/0_station_title.png"
}])


#*
Set data from custome object data on marketo
*#

#foreach($object in $ensen_eki_view_req_ranking_top7List)
#if($object.mail_key.contains('ensen_eki_browsing_ranking_in_7days'))
#foreach ($i in [1..7])

#set ($ensen_name = "${esc.d}object.ensen_name_${i}")
#set ($eki_name = "${esc.d}object.eki_name_${i}")
#set ($eki_search_url= "${esc.d}object.eki_search_url_${i}")
#set ($ensen_search_url= "${esc.d}object.ensen_search_url_${i}")

#set($j = $i - 1)
#set($ranking_crown_img_url = $bukken_ranking_img[$j].ranking_crown_img_url)
#set($ranking_line_img_url = $bukken_ranking_img[$j].ranking_line_img_url)
#set($ranking_border_line_color = $bukken_ranking_img[$j].ranking_border_line_color)
#set($line_title = $bukken_ranking_img[$j].line_title)
#set($station_title = $bukken_ranking_img[$j].station_title)


#*
Build utm_parameter
The parameter comented is using mytoken
*#
<!-- #if(${object.area_name}=="全国")
#set($utm_campaign = "mkt_all_area")
#elseif(${object.area_name}=="関東")
#set($utm_campaign = "mkt_kanto")
#elseif(${object.area_name}=="関西")
#set($utm_campaign = "mkt_kansai")
#elseif(${object.area_name}=="東京")
#set($utm_campaign = "mkt_tokyo")
#elseif(${object.area_name}=="神奈川")
#set($utm_campaign = "mkt_kanagawa")
#elseif(${object.area_name}=="千葉")
#set($utm_campaign = "mkt_chiba")
#elseif(${object.area_name}=="埼玉")
#set($utm_campaign = "mkt_saitama")
#elseif(${object.area_name}=="愛知")
#set($utm_campaign = "mkt_aichi")
#elseif(${object.area_name}=="大阪")
#set($utm_campaign = "mkt_osaka")
#elseif(${object.area_name}=="福岡")
#set($utm_campaign = "mkt_fukuoka")
#else
#set($utm_campaign = "mkt_other")
#end -->

<!-- #set($utm_medium = "mkt_dy_mail")
#set($utm_content = "browsing_bukken_ranking") -->
#set ($utm_term = "property_0${i}")

<!-- #set( $defaultTimeZone = $date.getTimeZone().getTimeZone("Asia/Tokyo") )
#set( $defaultLocale = $date.getLocale() )
#set( $calNow = $date.getCalendar() )
#set( $ret = $calNow.setTimeZone($defaultTimeZone) )
#set( $calConst = $field.in($calNow) )
#set( $ISO8601DateOnly = "yyyyMMdd" )
#set( $nowData_YYYYMMDD = $date.format($ISO8601DateOnly,$calNow,$defaultLocale,$defaultTimeZone) ) -->



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
                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFFFF;color:#000000;text-align: center;font-weight: 700;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;margin: 0;padding: 1em 0;">#evaluate($ensen_name)</p>

                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_colorborder-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                <p style="margin:0;padding-bottom: 1.5em;background-color: #FFFFFF;border-left: solid 1px $ranking_border_line_color ;border-right: solid 1px $ranking_border_line_color;box-sizing: border-box;">
                                    <!--[if gte mso | IE]>
                                                        <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="$ensen_search_url" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                                          <w:anchorlock/>
                                                          <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                                        </v:roundrect>
                                                      <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="#evaluate($ensen_search_url)&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_ensen&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
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
                                <p style="margin:0;padding-bottom: 1.5em;">
                                    <!--[if gte mso | IE]>
                                                        <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="$eki_search_url" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                                          <w:anchorlock/>
                                                          <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                                        </v:roundrect>
                                                      <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta_min" href="#evaluate($eki_search_url)&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn_eki&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:50%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">物件を見る ＞</a>
                                    <!--<![endif]-->
                                </p>
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