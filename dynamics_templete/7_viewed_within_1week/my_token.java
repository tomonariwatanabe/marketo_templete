#*
Add multiple array using an image link on marketo image
*#
#set( $bukken_ranking_img =
[{
"ranking_crown_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1.png",
"ranking_line_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png"
},{
"ranking_crown_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/2.png",
"ranking_line_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/2_line.png"
},{
"ranking_crown_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/3.png",
"ranking_line_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/3_line.png"
},{
"ranking_crown_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/4.png",
"ranking_line_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/4_line.png"
},{
"ranking_crown_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/5.png",
"ranking_line_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/5_line.png"
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
#if($object.mail_key.contains('browsing_ohd_bukken_ranking_in_7days'))
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

#*
Set data from custome object data on marketo
*#
#foreach($object in $view_req_ranking_top5List)
#if($object.mail_key.contains('browsing_ohd_bukken_ranking_in_7days'))
#foreach ($i in [1..5])
#set ($bukken_img_url = "${esc.d}object.bukken_img_url_${i}")

#set ($full_address = "${esc.d}object.full_address_${i}")
#set ($price = "${esc.d}object.price_${i}")
#set ($title = "${esc.d}object.title_${i}")
#set ($free_catch = "${esc.d}object.free_catch_${i}")
#set($j = $i - 1)
#set($ranking_crown_img_url = $bukken_ranking_img[$j].ranking_crown_img_url)
#set($ranking_line_img_url = $bukken_ranking_img[$j].ranking_line_img_url)


#set($title = "#evaluate($title)")
#set($free_catch = "#evaluate($free_catch)")
#set($price = "#evaluate($price)")
#set($full_address = "#evaluate($full_address)")
#set($bukken_img_url = "#evaluate($bukken_img_url)")

#*
Build utm_parameter
The parameter comented is using mytoken
*#
#if(${object.area_name}=="全国")
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
#end

#set($utm_medium = "mkt_dy_mail")
#set($utm_content = "browsing_bukken_ranking")
#set ($utm_term = "property_0${i}")


#set( $defaultTimeZone = $date.getTimeZone().getTimeZone("Asia/Tokyo") )
#set( $defaultLocale = $date.getLocale() )
#set( $calNow = $date.getCalendar() )
#set( $ret = $calNow.setTimeZone($defaultTimeZone) )
#set( $calConst = $field.in($calNow) )
#set( $ISO8601DateOnly = "yyyyMMdd" )
#set( $nowData_YYYYMMDD = $date.format($ISO8601DateOnly,$calNow,$defaultLocale,$defaultTimeZone) )



<!-- START ランキング物件 -->
<!-- START 空白１-->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellspacing="0" cellpadding="4px" border="0" width="100%" class="mktoModule" id="moduleSpace3" mktoName="空白１" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:${GlobalWidth};margin:0 auto;background-color:#fbf8eb;">
    <tbody>
        <tr>
            <td>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!-- END 空白１ -->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellpadding="0" cellspacing="0" class="mktoModule" id="moduleSpace5" mktoName="空白１" border="0" align="center" style="border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:${GlobalWidth};margin:0 auto;background-color:#FBF8EB;padding:0 11%">
    <tbody>
        <tr style="max-width:${GlobalWidth};width:100%;">
            <td style="padding:0;background-color:#FBF8EB;">

                <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
                <table class="main_table" cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:90%;max-width: 472px;background-color: #ffffff;border-radius: 6px;">
                    <tbody>
                        <tr>
                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;" valign="top">
                                <table class="table600" style="-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-spacing: 0; border-collapse: collapse; margin-top: 0; margin-right: auto; margin-bottom: 0; margin-left: auto;" align="center" border="0" cellpadding="0" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <td class="space_14" style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;display: block;" height="14px">&nbsp;</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding:10px;width:100%;padding: 0 5%;">
                                <div style="width:63%;margin:auto;">
                                    <img width="100%" src="https://oh.openhouse-group.com/simage/1092.jpg?size=L" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding: 0 7%;font-size: 16p;" class="title">
                                <a href="">
                                    <p style="font-size: 100%;mso-ansi-font-size:100%;line-height: 1.4em;background-color: #ffffff;color:#215EAF;text-align: center;font-weight: 900;margin: 0;margin-top: 8px;">オープンスタイル戸田ゆたかアクセス</p>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding: 0 7%;font-size: 14px;" class="address">
                                <p style="font-size: 100%;mso-ansi-font-size:100%;line-height: 1.4em;background-color: #ffffff;color:#000000;text-align: center;">愛知県名古屋市中川区戸田ゆたか１丁目<br>名古屋線 戸田駅 徒歩 10分<br>2880~3280万円 (税込)</p>
                            </td>
                        </tr>
                        <tr style="table-layout:fixed">
                            <td style="width: 43%;display: inline-table;margin-left: 7%;">
                                <a href="" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                    <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height:14px;vertical-align: text-bottom;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/arrow.png"></p>
                                </a>
                            </td>
                            <td style="width: 43%;display: inline-table;margin-right: 7%">
                                <a href="" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                    <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height:14px;vertical-align: text-bottom;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/arrow.png"></p>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px;">
                                <!--[if gte mso | IE]>
                                                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="http://" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                                              <w:anchorlock/>
                                                              <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                                            </v:roundrect>
                                                          <![endif]-->
                                <!--[if !gte !mso | !IE]><!-- -->
                                <a class="main_cta" href=" https://litmus.com" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:86%; text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                <!--<![endif]-->
                            </td>
                        </tr>
                        <tr>
                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;" valign="top">
                                <table class="table600" style="-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-spacing: 0; border-collapse: collapse; margin-top: 0; margin-right: auto; margin-bottom: 0; margin-left: auto;" align="center" border="0" cellpadding="0" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <td class="space_8" style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;display: block;" height="8px">&nbsp;</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px">
                                <!--[if gte mso | IE]>
                                                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="http://" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                                              <w:anchorlock/>
                                                              <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                                            </v:roundrect>
                                                          <![endif]-->
                                <!--[if !gte !mso | !IE]><!-- -->
                                <a class="main_cta" href="https://litmus.com" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:86% ;text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                <!--<![endif]-->
                            </td>
                        </tr>
                        <tr>
                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;" valign="top">
                                <table class="table600" style="-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-spacing: 0; border-collapse: collapse; margin-top: 0; margin-right: auto; margin-bottom: 0; margin-left: auto;" align="center" border="0" cellpadding="0" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <td style="-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;mso-table-lspace: 0pt;mso-table-rspace: 0pt;word-break: break-word;-webkit-hyphens: none;-moz-hyphens: none;hyphens: none;border-collapse: collapse;display: block;" height="20px">&nbsp;</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!-- START 空白１-->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellspacing="0" cellpadding="4px" border="0" width="100%" class="mktoModule" id="moduleSpace4" mktoName="空白１" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:${GlobalWidth};margin:0 auto;background-color:#fbf8eb">
    <tbody>
        <tr>
            <td>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!-- END 空白１ -->
#end
#end
#end