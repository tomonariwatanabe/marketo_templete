<!-- START ランキング物件 -->
#*
Set data from custome object data on marketo
*#
#set ($d = '$')
#set($title_name = "municipality_id")
#foreach($object in $similar_to_past_req_bukkenList)
#if($object.mail_key.contains('past_request_similar_bukken_in_90days'))

#*
最初の物件名がなかったらすべてを表示させないようにする
*#
#set($osusume_bukken_accsess = "${d}object.${title_name}_osusume_bukken_name_1")
#set($osusume_bukken_accsess = "#evaluate($osusume_bukken_accsess)")
#if(!$osusume_bukken_accsess.contains('$'))

<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellspacing="0" cellpadding="20px" border="0" width="100%" class="mktoModule" id="moduleRanking_spacer" mktoName="ランキング＿空白" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:${GlobalWidth};margin:0 auto;background-color:${GlobalBackgroundColor};">
    <tbody>
        <tr>
            <td>
            </td>
        </tr>
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellpadding="0" cellspacing="0" border="0" align="center" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:${GlobalWidth};margin:0 auto;background-color:#FFFEF8;padding:0 11%">
    <tbody>
        <tr style="max-width:${GlobalWidth};width:100%">
            <td style="padding:0;">
                <img width="100%" alt="価格でおすすめの物件" src="http://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/ttl01.png">
            </td>
        </tr>
        #foreach ($i in [1..2])

        #set ($osusume_bukken_accsess = "${d}object.${title_name}_osusume_bukken_accsess_${i}")
        #set ($osusume_bukken_img_url = "${d}object.${title_name}_osusume_bukken_img_url_${i}")
        #set ($osusume_bukken_name = "${d}object.${title_name}_osusume_bukken_name_${i}")
        #set ($osusume_bukken_url = "${d}object.${title_name}_osusume_bukken_url_${i}")
        #set ($osusume_free_catch = "${d}object.${title_name}_osusume_free_catch_${i}")
        #set ($osusume_full_address = "${d}object.${title_name}_osusume_full_address_${i}")
        #set ($osusume_price = "${d}object.${title_name}_osusume_price_${i}")

        #set($bukken_base_url = "#evaluate($osusume_bukken_url)")
        #set($bukken_id = $bukken_base_url.replaceAll("oh.openhouse-group.com.*?\/(.*)/(.*)/(.*)\/", "$3"))


        #*
        Build utm_parameter
        The parameter comented is using mytoken
        *#

        #set ($utm_term = "property_municipality_0${i}")

        <tr style="max-width:${GlobalWidth};width:100%">
            <td style="padding:0;background-color:#FFFEF8;">
                <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:80%;max-width: 480px;">
                    <tbody>
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
                            <td>
                                <a href="http://${bukken_base_url}?staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}">
                                    <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #FFFEF8;color:#215EAF;text-align: center;font-weight: 900;">#evaluate($osusume_bukken_name)</p>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 15px;mso-ansi-font-size:15px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: left;font-weight: 700;">#evaluate($osusume_free_catch)</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;background-color: #FFFEF8;color:#000000;text-align: center;">#evaluate($osusume_full_address)<br>#evaluate($osusume_price)</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/1_line.png">
                            </td>
                        </tr>
                        <tr style="table-layout:fixed">
                            <td style="width: 50%;display: inline-table;">
                                <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                    <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;max-height: 14px;min-height: 14px;vertical-align: text-bottom;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/arrow.png"></p>
                                </a>
                            </td>
                            <td style="width: 50%;display: inline-table;">
                                <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                    <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;max-height: 14px;min-height: 14px;vertical-align: text-bottom;" src="https://334-SCB-946.mktoweb.com/rs/334-SCB-946/images/arrow.png"></p>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding:10px;width:100%;">
                                <img width="100%" src="https://#evaluate($osusume_bukken_img_url)" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" style="border-radius: 5px;">
                                <!--[if gte mso | IE]>
                                                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                                              <w:anchorlock/>
                                                              <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                                            </v:roundrect>
                                                          <![endif]-->
                                <!--[if !gte !mso | !IE]><!-- -->
                                <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
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
                                                            <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                                              <w:anchorlock/>
                                                              <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                                            </v:roundrect>
                                                          <![endif]-->
                                <!--[if !gte !mso | !IE]><!-- -->
                                <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id}&staff_id=${lead.userEmailAccountName}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=${utm_term}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                <!--<![endif]-->
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        #end
    </tbody>
</table>
<!--[if mso | IE]></table><![endif]-->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellspacing="0" cellpadding="20px" border="0" width="100%" class="mktoModule" id="moduleRanking_spacer" mktoName="ランキング＿空白" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:${GlobalWidth};margin:0 auto;background-color:#FFFEF8;">
    <tbody>
        <tr>
            <td>
            </td>
        </tr>
    </tbody>
</table>
<!-- END ランキング物件 -->
#end
#end
#end