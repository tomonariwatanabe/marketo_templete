#*
Add multiple array using an image link on marketo image
*#
#set( $bukken_ranking_img =
[{
"ranking_house_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/rank01.png"
},{
"ranking_house_img_url":"http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/rank02.png"
}])


#*
Set data from custome object data on marketo
*#
#set ($d = '$')
#foreach($object in $similar_to_browsing_bukken_in_14daysList)
#if($object.mail_key.contains('similar_to_latest_2_bukken_browsing_in_14day'))
#foreach ($i in [1..2])
#set ($bukken_full_address = "${d}object.bukken_${i}_full_address")
#set ($bukken_img_url = "${d}object.bukken_${i}_img_url")
#set ($bukken_price = "${d}object.bukken_${i}_price")
#set ($bukken_url = "${d}object.bukken_${i}_url")
#set ($bukken_accsess = "${d}object.bukken_${i}_accsess")
#set($bukken_base_url = "#evaluate($bukken_url)")
#set($bukken_id = $bukken_base_url.replaceAll("https?:\/{2,}.*?\/(.*)/(.*)/(.*)\/", "$3"))

#set($j = $i - 1)
#set($ranking_house_img_url = $bukken_ranking_img[$j].ranking_house_img_url)


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
#set($utm_content = "similar_to_latest_2_bukken_browsing_in_14day") -->
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
<table cellpadding="0" cellspacing="0" border="0" align="center" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:${GlobalWidth};margin:0 auto;background-color:${GlobalBackgroundColor};padding:0 11%">
    <tbody>

        <!--上側の余白 -->
        <tr style="background-color:${GlobalBackgroundColor};">
            <td><br></td>
        </tr>
        <tr style="background-color:${GlobalBackgroundColor};">
            <td style="padding:0;">
                <img width="100%" alt="${i}件目" src="$ranking_house_img_url">
            </td>
        </tr>
        <tr style="background-color:${GlobalBackgroundColor};">
            <td><br></td>
        </tr>

        <!-- 物件情報 -->
        <tr style="background-color:${GlobalBackgroundColor};">
            <td>
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:80%;max-width: 480px;">
                    <tbody>
                        <tr>
                            <td>
                                <a href="">
                                    <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;color:#215EAF;text-align: center;font-weight: 900;">#evaluate($bukken_full_address)</p>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td><img width="100%" src="#evaluate($bukken_img_url)" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;"></td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;color:#000000;text-align: center;">#evaluate($bukken_accsess)<br>#evaluate($bukken_price)${GlobalBackgroundColor}</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>

        <!-- 余白 -->
        <tr style="background-color:${GlobalBackgroundColor};">
            <td><br><br><br></td>
        </tr>

        <!-- おすすめ物件 -->
        <tr style="background-color:${GlobalBackgroundColor};">
            <td>
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:90%;">
                    <tbody>
                        <tr>
                            <td>
                                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:93%;">
                                    <tr style="background: #fff;">
                                        <td><br><br></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr style="background:#DBB93C;color: #fff;">
                            <td style="padding: 18px;text-align: center;font-weight: bold;font-size: 18px;">
                                類似おすすめ物件
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/yellow_ribon.png" alt="">
                            </td>
                        </tr>
                        #set($LAST = 3)
                        #foreach ($k in [1..$LAST])
                        #set ($osusume_bukken_accsess = "${d}object.bukken_${i}_osusume_bukken_accsess_${k}")
                        #set ($osusume_bukken_free_catch = "${d}object.bukken_${i}_osusume_bukken_free_catch_${k}")
                        #set ($osusume_bukken_full_address = "${d}object.bukken_${i}_osusume_bukken_full_address_${k}")
                        #set ($osusume_bukken_img_url = "${d}object.bukken_${i}_osusume_bukken_img_url_${k}")
                        #set ($osusume_bukken_price = "${d}object.bukken_${i}_osusume_bukken_price_${k}")
                        #set ($osusume_bukken_url = "${d}object.bukken_${i}_osusume_bukken_url_${k}")
                        #set($osusume_bukken_id = $osusume_bukken_url.replaceAll("https?:\/{2,}.*?\/(.*)/(.*)/(.*)\/", "$3"))
                        <!-- おすすめ物件1 -->
                        <tr>
                            <td>
                                <table cellspacing="0" cellpadding="0" align="center" style="background: #fff;border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:93%;">
                                    <tr>
                                        <td>
                                            <a href="">
                                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;color:#215EAF;text-align: center;font-weight: 900;">#evaluate($osusume_bukken_full_address)</p>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p style="width:90%;margin-left:auto;margin-right:auto;font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;color:#000000;text-align: left;">#evaluate($osusume_bukken_free_catch)</p>
                                        </td>
                                    </tr>
                                    <tr width="100">
                                        <td>
                                            <img width="90%" style="margin:0 auto;display: block;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;color:#000000;text-align: center;">#evaluate($osusume_bukken_accsess)<br>#evaluate($osusume_bukken_price)</p>
                                        </td>
                                    </tr>
                                    <tr width="100">
                                        <td>
                                            <img width="90%" style="margin:0 auto;display: block;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png">
                                        </td>
                                    </tr>
                                    <tr style="table-layout:fixed">
                                        <td style="width: 50%;display: inline-table;">
                                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF; ">
                                                <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: center;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;vertical-align:middle;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/arrow.png"></p>
                                            </a>
                                        </td>
                                        <td style="width: 50%;display: inline-table;text-align: center;">
                                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${osusume_bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF; ">
                                                <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: center;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;vertical-align: middle;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/arrow.png"></p>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align:center;"><br></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align:center;"><img width="80%" src="#evaluate($osusume_bukken_img_url)" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;"></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align:center;"><br><br></td>
                                    </tr>
                                    <tr>
                                        <td align="center" style="border-radius: 5px;">
                                            <!--[if gte mso | IE]>
                                                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="http://" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                                                    <w:anchorlock/>
                                                                    <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                                                    </v:roundrect>
                                                                <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=red_btn&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">＞ 図面を受け取る</a>
                                            <!--<![endif]-->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align:center;"><br></td>
                                    </tr>
                                    <tr>
                                        <td align="center" style="border-radius: 5px">
                                            <!--[if gte mso | IE]>
                                                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="http://" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                                                    <w:anchorlock/>
                                                                    <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                                                    </v:roundrect>
                                                                <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${osusume_bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=wht_btn&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">＞ 詳しく見る</a>
                                            <!--<![endif]-->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align:center;"><br><br><br></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>

                        #if($k != $LAST )
                        <tr>
                            <td>
                                <table cellspacing="0" cellpadding="0" align="center" style="background: #fff;border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:93%;">

                                    <!-- 区切り線(2回目以降？)　ここから -->
                                    <tr>
                                        <td>
                                            <p style="width:90%;height:3px;background:#FBF8EB;margin-right:auto;margin-left: auto;"></p>
                                            <br>
                                        </td>
                                    </tr>
                                    <!-- 区切り線(2回目以降？)　ここまで -->
                                </table>
                            </td>
                        </tr>
                        #end
                        #end
                        <tr>
                            <td><br><br><br></td>
                        </tr>
                    </tbody>
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