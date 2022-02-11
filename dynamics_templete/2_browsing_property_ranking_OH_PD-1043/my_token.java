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
Set link macro 
*#

## タイトル
#macro(link__title $bukken_area,$bukken_id,$utm_term)
<a href="https://oh.openhouse-group.com/$bukken_area/bukken/$bukken_id/?staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0$utm_term&banner_id=${nowData_YYYYMMDD}">
    <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFEF8;color:#215EAF;text-align: center;font-weight: 900;">$title</p>
</a>
#end

## 資料請求はこちら
#macro(link__req_btn_s $bukken_id,$utm_term)
<a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=$bukken_id&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0$utm_term&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
    <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/arrow.png"></p>
</a>
#end

## 見学予約はこちら
#macro(link__res_btn_s $bukken_id,$utm_term)
<a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=$bukken_id&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0$utm_term&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
    <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/arrow.png"></p>
</a>
#end

## 画像
#macro(link__image $bukken_id,$utm_term)
<a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=$bukken_id&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=$utm_term&banner_id=${nowData_YYYYMMDD}">
    <img width="100%" src="https://$bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
</a>
#end

## 図面を受け取る
#macro(link__req_btn $bukken_id,$utm_term)
<!--[if gte mso | IE]>
    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=$bukken_id&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0$utm_term&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
        <w:anchorlock/>
            <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
    </v:roundrect>
<![endif]-->
<!--[if !gte !mso | !IE]><!-- -->
    <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=$bukken_id&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0$utm_term&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
<!--<![endif]-->
#end

## 詳しく見る
#macro(link__detail_btn $bukken_area,$bukken_id,$utm_term)
<!--[if gte mso | IE]>
    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/$bukken_area/bukken/$bukken_id/?staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0$utm_term&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
        <w:anchorlock/>
        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
    </v:roundrect>
<![endif]-->
<!--[if !gte !mso | !IE]><!-- -->
    <a class="main_cta" href="https://oh.openhouse-group.com/$bukken_area/bukken/$bukken_id/?staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0$utm_term&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
<!--<![endif]-->
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


#set($title  = "#evaluate($title)")
#set($free_catch  = "#evaluate($free_catch)")
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
                            #if( $i == 1 )
                            #link__title(${bukken_area_1},${bukken_id_1},${utm_term_1})
                            #end
                            #if( $i == 2 )
                            #link__title(${bukken_area_2},${bukken_id_2},${utm_term_2})
                            #end
                            #if( $i == 3 )
                            #link__title(${bukken_area_3},${bukken_id_3},${utm_term_3})
                            #end
                            #if( $i == 4 )
                            #link__title(${bukken_area_4},${bukken_id_4},${utm_term_4})
                            #end
                            #if( $i == 5 )
                            #link__title(${bukken_area_5},${bukken_id_5},${utm_term_5})
                            #end
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 15px;mso-ansi-font-size:15px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: left;font-weight: 700;">$free_catch</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>

                                <img width="100%" style="margin:0 auto;display: block;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: center;">$full_address<br>名古屋線 戸田駅 徒歩 10分<br>$price</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png">
                            </td>
                        </tr>

                        <tr style="table-layout:fixed">
                            <td style="width: 50%;display: inline-table;">
                            #if( $i == 1 )
                            #link__req_btn_s(${bukken_id_1},${utm_term_1})
                            #end
                            #if( $i == 2 )
                            #link__req_btn_s(${bukken_id_2},${utm_term_2})
                            #end
                            #if( $i == 3 )
                            #link__req_btn_s(${bukken_id_3},${utm_term_3})
                            #end
                            #if( $i == 4 )
                            #link__req_btn_s(${bukken_id_4},${utm_term_4})
                            #end
                            #if( $i == 5 )
                            #link__req_btn_s(${bukken_id_5},${utm_term_5})
                            #end
                            </td>
                            <td style="width: 50%;display: inline-table;">
                            #if( $i == 1 )
                            #link__res_btn_s(${bukken_id_1},${utm_term_1})
                            #end
                            #if( $i == 2 )
                            #link__res_btn_s(${bukken_id_2},${utm_term_2})
                            #end
                            #if( $i == 3 )
                            #link__res_btn_s(${bukken_id_3},${utm_term_3})
                            #end
                            #if( $i == 4 )
                            #link__res_btn_s(${bukken_id_4},${utm_term_4})
                            #end
                            #if( $i == 5 )
                            #link__res_btn_s(${bukken_id_5},${utm_term_5})
                            #end
                            </td>
                        </tr>
                        <tr>
                            <td style="padding:10px;width:100%;">
                            #if( $i == 1 )
                            #link__image(${bukken_id_1},${utm_term_1})
                            #end
                            #if( $i == 2 )
                            #link__image(${bukken_id_2},${utm_term_2})
                            #end
                            #if( $i == 3 )
                            #link__image(${bukken_id_3},${utm_term_3})
                            #end
                            #if( $i == 4 )
                            #link__image(${bukken_id_4},${utm_term_4})
                            #end
                            #if( $i == 5 )
                            #link__image(${bukken_id_5},${utm_term_5})
                            #end
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px;">
                            #if( $i == 1 )
                            #link__req_btn(${bukken_id_1},${utm_term_1})
                            #end
                            #if( $i == 2 )
                            #link__req_btn(${bukken_id_2},${utm_term_2})
                            #end
                            #if( $i == 3 )
                            #link__req_btn(${bukken_id_3},${utm_term_3})
                            #end
                            #if( $i == 4 )
                            #link__req_btn(${bukken_id_4},${utm_term_4})
                            #end
                            #if( $i == 5 )
                            #link__req_btn(${bukken_id_5},${utm_term_5})
                            #end
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
                            #if( $i == 1 )
                            #link__detail_btn($bukken_area_1,$bukken_id_1,$utm_term_1)
                            #end
                            #if( $i == 2 )
                            #link__detail_btn($bukken_area_2,$bukken_id_2,$utm_term_2)
                            #end
                            #if( $i == 3 )
                            #link__detail_btn($bukken_area_3,$bukken_id_3,$utm_term_3)
                            #end
                            #if( $i == 4 )
                            #link__detail_btn($bukken_area_4,$bukken_id_4,$utm_term_4)
                            #end
                            #if( $i == 5 )
                            #link__detail_btn($bukken_area_5,$bukken_id_5,$utm_term_5)
                            #end
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
#end
#end
#end