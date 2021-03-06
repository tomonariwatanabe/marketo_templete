#*
Build utm_parameter
The parameter comented is using mytoken
*#
#set($utm_campaign = "mkt_other")
#set($utm_medium = "mkt_dy_mail")
#set($utm_content = "similar_to_latest_2_bukken_browsing_in_14day")


#set($LAST = 3)
#*
Add multiple array using an image link on marketo image
*#
#set( $bukken_ranking_img =
[{
"ranking_house_img_url":"{%image.01_order_2202%}"
},{
"ranking_house_img_url":"{%image.02_order_2202%}"
}])

#*
Set staff_id Parameter
*#
#if($lead.userEmailAccountName.length() > 0)
#set($staff_id_param = "&staff_id=${lead.userEmailAccountName}")
#else
#set($staff_id_param = "")
#end

#set( $defaultTimeZone = $date.getTimeZone().getTimeZone("Asia/Tokyo") )
#set( $defaultLocale = $date.getLocale() )
#set( $calNow = $date.getCalendar() )
#set( $ret = $calNow.setTimeZone($defaultTimeZone) )
#set( $calConst = $field.in($calNow) )
#set( $ISO8601DateOnly = "yyyyMMdd" )
#set( $banner_id = $date.format($ISO8601DateOnly,$calNow,$defaultLocale,$defaultTimeZone) )
#set($y = ${convert.parseDate($banner_id, 'yyyyMMdd')})

#*
Set link from custome object data on marketo
*#
#foreach($object in $similar_to_browsing_bukken_in_14daysList)
#if($object.mail_key.contains('similar_to_latest_2_bukken_browsing_in_14day'))
#set($x = ${convert.parseDate($object.effect_date, 'yyyy-MM-dd')})
#if($date.whenIs($x,$y).days == 0)
#foreach ($i in [1..2])

#set($bukken_url = "${esc.d}object.bukken_${i}_url")
#set($bukken_base_url = "#evaluate($bukken_url)")
#set($bukken_id = $bukken_base_url.replaceAll("oh.openhouse-group.com.*?\/(.*)/(.*)/(.*)\/", "$3"))
#set($bukken_area = $bukken_base_url.replaceAll("oh.openhouse-group.com.*?\/(.*)/(.*)/(.*)\/", "$1"))

#evaluate( "${esc.h}set( ${esc.d}bukken_area_${i} = ${esc.d}bukken_area )" )
#evaluate( "${esc.h}set( ${esc.d}bukken_id_${i} = ${esc.d}bukken_id)" )
#evaluate( "${esc.h}set( ${esc.d}utm_term_${i} = ${esc.d}i )" )


#foreach ($k in [1..$LAST])

#set ($osusume_bukken_url = "${esc.d}object.bukken_${i}_osusume_bukken_url_${k}")
#set($osusume_bukken_base_url = "#evaluate($osusume_bukken_url)")
#set($osusume_bukken_id = $osusume_bukken_base_url.replaceAll("oh.openhouse-group.com.*?\/(.*)/(.*)/(.*)\/", "$3"))
#set($osusume_bukken_area = $osusume_bukken_base_url.replaceAll("oh.openhouse-group.com.*?\/(.*)/(.*)/(.*)\/", "$1"))

#set($osusume_bukken_utm = "${i}_osusume_0${k}")


#evaluate( "${esc.h}set( ${esc.d}osusume_bukken_area_${k} = ${esc.d}osusume_bukken_area )" )
#evaluate( "${esc.h}set( ${esc.d}osusume_bukken_id_${k} = ${esc.d}osusume_bukken_id)" )
#evaluate( "${esc.h}set( ${esc.d}osusume_bukken_utm_term_${i}_${k} = ${esc.d}osusume_bukken_utm)" )

#end
#end
#end
#end
#end


#*
Set data from custome object data on marketo
*#

#foreach($object in $similar_to_browsing_bukken_in_14daysList)
#if($object.mail_key.contains('similar_to_latest_2_bukken_browsing_in_14day'))
#set($x = ${convert.parseDate($object.effect_date, 'yyyy-MM-dd')})
#if($date.whenIs($x,$y).days == 0)
#foreach ($i in [1..2])
#set ($bukken_full_address = "${esc.d}object.bukken_${i}_full_address")
#set ($bukken_img_url = "${esc.d}object.bukken_${i}_img_url")
#set ($bukken_price = "${esc.d}object.bukken_${i}_price")
#set ($bukken_accsess = "${esc.d}object.bukken_${i}_accsess")


#set($j = $i - 1)
#set($ranking_house_img_url = $bukken_ranking_img[$j].ranking_house_img_url)

#set($title = "#evaluate($bukken_full_address)")
#set($bukken_price = "#evaluate($bukken_price)")
#set($bukken_img_url = "#evaluate($bukken_img_url)")
#set($bukken_accsess = "#evaluate($bukken_accsess)")


#set( $defaultTimeZone = $date.getTimeZone().getTimeZone("Asia/Tokyo") )
#set( $defaultLocale = $date.getLocale() )
#set( $calNow = $date.getCalendar() )
#set( $ret = $calNow.setTimeZone($defaultTimeZone) )
#set( $calConst = $field.in($calNow) )
#set( $ISO8601DateOnly = "yyyyMMdd" )
#set( $nowData_YYYYMMDD = $date.format($ISO8601DateOnly,$calNow,$defaultLocale,$defaultTimeZone) )



<!-- START ??????????????? -->
<!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><![endif]-->
<table cellpadding="0" cellspacing="0" border="0" align="center" style="border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:${GlobalWidth};margin:0 auto;background-color:#FBF8EB;padding:0 11%">
    <tbody>

        <!--??????????????? -->
        <tr style="background-color:#FBF8EB;">
            <td><br></td>
        </tr>
        <tr style="background-color:#FBF8EB;">
            <td style="padding:0;">
                <img width="100%" alt="${i}??????" src="$ranking_house_img_url">
            </td>
        </tr>
        <tr style="background-color:#FBF8EB;">
            <td><br></td>
        </tr>

        <!-- ???????????? -->
        <tr style="background-color:#FBF8EB;">
            <td>
                <table cellspacing="0" cellpadding="0" align="center" style="border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:80%;max-width: 480px;">
                    <tbody>
                        <tr>
                            <td>
                                #if( $i == 1 )
                                <a href="https://oh.openhouse-group.com/${bukken_area_1}/bukken/${bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                    <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #fbf8eb;color:#215EAF;text-align: center;font-weight: 900;">$title</p>
                                </a>
                                #end
                                #if( $i == 2 )
                                <a href="https://oh.openhouse-group.com/${bukken_area_2}/bukken/${bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                    <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #fbf8eb;color:#225EAF;text-align: center;font-weight: 900;">$title</p>
                                </a>
                                #end
                            </td>
                        </tr>
                        <tr>
                            <td><img width="100%" src="https://#evaluate($bukken_img_url)" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;"></td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;color:#000000;text-align: center;">$bukken_accsess<br>$bukken_price</p>
                            </td>
                        </tr>
                        <tr width="100">
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>

        <!-- ?????? -->
        <tr style="background-color:#FBF8EB;">
            <td><br><br><br></td>
        </tr>

        <!-- ?????????????????? -->
        <tr style="background-color:#FBF8EB;">
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
                                ????????????????????????
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img width="100%" style="margin:0 auto;display: block;" src="{%image.yellow_ribon_2202%}" alt="">
                            </td>
                        </tr>
                        #set($LAST = 3)
                        #foreach ($k in [1..$LAST])
                        #set ($osusume_bukken_accsess = "${esc.d}object.bukken_${i}_osusume_bukken_accsess_${k}")
                        #set ($osusume_bukken_full_address = "${esc.d}object.bukken_${i}_osusume_bukken_full_address_${k}")
                        #set ($osusume_bukken_img_url = "${esc.d}object.bukken_${i}_osusume_bukken_img_url_${k}")
                        #set ($osusume_bukken_price = "${esc.d}object.bukken_${i}_osusume_bukken_price_${k}")

                        #set($osusume_title = "#evaluate($osusume_bukken_full_address)")
                        #set($osusume_bukken_accsess = "#evaluate($osusume_bukken_accsess)")
                        #set($osusume_bukken_img_url = "#evaluate($osusume_bukken_img_url)")
                        #set($osusume_bukken_price = "#evaluate($osusume_bukken_price)")
                        #set($bukken_img_url = "#evaluate($bukken_img_url)")


                        <!-- ??????????????????1 -->
                        <tr>
                            <td>
                                <table cellspacing="0" cellpadding="0" align="center" style="background: #fff;border-collapse: collapse;border-spacing: 0;border: 0; padding: 0;margin:0 auto ;width:93%;">
                                    <tr>
                                        <td>
                                            #if( $i == 1)
                                            #if( $k == 1 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#215EAF;text-align: center;font-weight: 900;">$osusume_title</p>
                                            </a>
                                            #end
                                            #if( $k == 2 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#225EAF;text-align: center;font-weight: 900;">$osusume_title</p>
                                            </a>
                                            #end
                                            #if( $k == 3 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#335EAF;text-align: center;font-weight: 900;">$osusume_title</p>
                                            </a>
                                            #end
                                            #end
                                            #if( $i == 2)
                                            #if( $k == 1 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#215EAF;text-align: center;font-weight: 900;">$osusume_title</p>
                                            </a>
                                            #end
                                            #if( $k == 2 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#225EAF;text-align: center;font-weight: 900;">$osusume_title</p>
                                            </a>
                                            #end
                                            #if( $k == 3 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#335EAF;text-align: center;font-weight: 900;">$osusume_title</p>
                                            </a>
                                            #end
                                            #end

                                        </td>
                                    </tr>
                                    <!-- <tr>
                                        <td>
                                            <p style="width:90%;margin-left:auto;margin-right:auto;font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;color:#000000;text-align: left;">#evaluate($osusume_bukken_free_catch)</p>
                                        </td>
                                    </tr> -->
                                    <tr width="100">
                                        <td>
                                            <img width="90%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1.4em;color:#000000;text-align: center;">$osusume_bukken_accsess<br>$osusume_bukken_price</p>
                                        </td>
                                    </tr>
                                    <tr width="100">
                                        <td>
                                            <img width="90%" style="margin:0 auto;display: block;" src="{%image.dotted_line_gold_2202%}">
                                        </td>
                                    </tr>
                                    <tr style="table-layout:fixed">
                                    <td class="left_btn" style="width: 46%;display: inline-table;margin-left: 4%;">
                                            #if( $i == 1)
                                            #if( $k == 1 )
                                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_1}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #if( $k == 2 )
                                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_2}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #if( $k == 3 )
                                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_3}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #end
                                            #if( $i == 2)
                                            #if( $k == 1 )
                                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_1}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #if( $k == 2 )
                                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_2}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #if( $k == 3 )
                                            <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_3}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #end
                                        </td>
                                        <td class="right_btn" style="width: 46%;display: inline-table;margin-right: 4%">
                                            #if( $i == 1)
                                            #if( $k == 1 )
                                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${osusume_bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_1}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #if( $k == 2 )
                                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${osusume_bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_2}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #if( $k == 3 )
                                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${osusume_bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_3}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #end
                                            #if( $i == 2)
                                            #if( $k == 1 )
                                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${osusume_bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_1}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #if( $k == 2 )
                                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${osusume_bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_2}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #if( $k == 3 )
                                            <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${osusume_bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_3}&banner_id=${nowData_YYYYMMDD}" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                                <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">????????????????????????&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                            </a>
                                            #end
                                            #end
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align:center;"><br></td>
                                    </tr>
                                    <tr>
                                        <td style="padding:10px;width:100%;">
                                            #if( $i == 1)
                                            #if( $k == 1 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <img width="100%" src="https://$osusume_bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                            </a>
                                            #end
                                            #if( $k == 2 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <img width="100%" src="https://$osusume_bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                            </a>
                                            #end
                                            #if( $k == 3 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <img width="100%" src="https://$osusume_bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                            </a>
                                            #end
                                            #end
                                            #if( $i == 2)
                                            #if( $k == 1 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <img width="100%" src="https://$osusume_bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                            </a>
                                            #end
                                            #if( $k == 2 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <img width="100%" src="https://$osusume_bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                            </a>
                                            #end
                                            #if( $k == 3 )
                                            <a href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param">
                                                <img width="100%" src="https://$osusume_bukken_img_url" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                            </a>
                                            #end
                                            #end
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align:center;"><br><br></td>
                                    </tr>
                                    <tr>
                                        <td align="center" style="border-radius: 5px;">
                                            #if( $i == 1)
                                            #if( $k == 1 )
                                            <!--[if gte mso | IE]>
                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_1}&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                        <w:anchorlock/>
                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">?????????????????????</center>
                    </v:roundrect>
                    <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_1}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ?????????????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 2 )
                                            <!--[if gte mso | IE]>
                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_2}&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                        <w:anchorlock/>
                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">?????????????????????</center>
                    </v:roundrect>
                    <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_2}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ?????????????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 3 )
                                            <!--[if gte mso | IE]>
                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_3}&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                        <w:anchorlock/>
                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">?????????????????????</center>
                    </v:roundrect>
                    <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_3}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ?????????????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #end
                                            #if( $i == 2)
                                            #if( $k == 1 )
                                            <!--[if gte mso | IE]>
                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_1}&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                        <w:anchorlock/>
                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">?????????????????????</center>
                    </v:roundrect>
                    <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_1}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ?????????????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 2 )
                                            <!--[if gte mso | IE]>
                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_2}&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                        <w:anchorlock/>
                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">?????????????????????</center>
                    </v:roundrect>
                    <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_2}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ?????????????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 3 )
                                            <!--[if gte mso | IE]>
                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_3}&banner_id=${nowData_YYYYMMDD}" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                        <w:anchorlock/>
                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">?????????????????????</center>
                    </v:roundrect>
                    <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${osusume_bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_3}&banner_id=${nowData_YYYYMMDD}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:90%; text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ?????????????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #end
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align:center;"><br></td>
                                    </tr>
                                    <tr>
                                        <td align="center" style="border-radius: 5px">
                                            #if( $i == 1)
                                            #if( $k == 1 )
                                            <!--[if gte mso | IE]>
                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                        <w:anchorlock/>
                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">???????????????</center>
                    </v:roundrect>
                    <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ???????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 2 )
                                            <!--[if gte mso | IE]>
                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                        <w:anchorlock/>
                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">???????????????</center>
                    </v:roundrect>
                    <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ???????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 3 )
                                            <!--[if gte mso | IE]>
                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                        <w:anchorlock/>
                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">???????????????</center>
                    </v:roundrect>
                    <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_1_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ???????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #end
                                            #if( $i == 2)
                                            #if( $k == 1 )
                                            <!--[if gte mso | IE]>
        <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
            <w:anchorlock/>
            <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">???????????????</center>
        </v:roundrect>
        <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ???????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 2 )
                                            <!--[if gte mso | IE]>
        <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
            <w:anchorlock/>
            <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">???????????????</center>
        </v:roundrect>
        <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ???????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 3 )
                                            <!--[if gte mso | IE]>
        <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
            <w:anchorlock/>
            <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">???????????????</center>
        </v:roundrect>
        <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_2_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ???????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #end
                                            #if( $i == 3)
                                            #if( $k == 1 )
                                            <!--[if gte mso | IE]>
        <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_3_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
            <w:anchorlock/>
            <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">???????????????</center>
        </v:roundrect>
        <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/${osusume_bukken_area_1}/bukken/${osusume_bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_3_1}&banner_id=${nowData_YYYYMMDD}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ???????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 2 )
                                            <!--[if gte mso | IE]>
        <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_3_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
            <w:anchorlock/>
            <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">???????????????</center>
        </v:roundrect>
        <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/${osusume_bukken_area_2}/bukken/${osusume_bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_3_2}&banner_id=${nowData_YYYYMMDD}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ???????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #if( $k == 3 )
                                            <!--[if gte mso | IE]>
        <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_3_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param" style="height:50px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
            <w:anchorlock/>
            <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">???????????????</center>
        </v:roundrect>
        <![endif]-->
                                            <!--[if !gte !mso | !IE]><!-- -->
                                            <a class="main_cta" href="https://oh.openhouse-group.com/${osusume_bukken_area_3}/bukken/${osusume_bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${osusume_bukken_utm_term_3_3}&banner_id=${nowData_YYYYMMDD}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:90% ;text-decoration: none;border-radius: 5px; padding: 12px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">?????? ???????????????</a>
                                            <!--<![endif]-->
                                            #end
                                            #end
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

                                    <!-- ????????????(2???????????????)??????????????? -->
                                    <tr>
                                        <td>
                                            <p style="width:90%;height:3px;background:#FBF8EB;margin-right:auto;margin-left: auto;"></p>
                                            <br>
                                        </td>
                                    </tr>
                                    <!-- ????????????(2???????????????)??????????????? -->
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
<!-- END ??????????????? -->
#end
#end
#end
#end