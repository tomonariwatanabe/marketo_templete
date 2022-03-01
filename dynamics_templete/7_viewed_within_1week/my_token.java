#*
Build utm_parameter
The parameter comented is using mytoken
*#
#set($utm_campaign = "mkt_other")
#set($utm_medium = "mkt_dy_mail")
#set($utm_content = "viewed_within_1week")

#set( $defaultTimeZone = $date.getTimeZone().getTimeZone("Asia/Tokyo") )
#set( $defaultLocale = $date.getLocale() )
#set( $calNow = $date.getCalendar() )
#set( $ret = $calNow.setTimeZone($defaultTimeZone) )
#set( $calConst = $field.in($calNow) )
#set( $ISO8601DateOnly = "yyyyMMdd" )
#set( $banner_id = $date.format($ISO8601DateOnly,$calNow,$defaultLocale,$defaultTimeZone) )
#set($y = ${convert.parseDate($banner_id, 'yyyyMMdd')})

#*
Set staff_id Parameter
*#
#if($lead.userEmailAccountName.length() > 0)
#set($staff_id_param = "&staff_id=${lead.userEmailAccountName}")
#else
#set($staff_id_param = "")
#end

#set($count_num = 1)

#*
Set link from custome object data on marketo
*#
#foreach($object in $PropertiesAccessList)
#set($x = ${convert.parseDate($object.access_date, 'yyyy-MM-dd')})
#if($date.whenIs($x,$y).days < 8) #* Set area valiable *# #if($object.prefecture.matches(".*(東京|千葉|埼玉|神奈川).")) #set($area="kanto" ) #elseif($object.prefecture.matches(".*(愛知|名古屋|岐阜).")) #set($area="nagoya" ) #elseif($object.prefecture.matches(".*(大阪|兵庫).")) #set($area="kansai" ) #elseif($object.prefecture.matches(".*(福岡).")) #set($area="fukuoka" ) #else <!-- When the variable is empty,the propaty is not displayed -->
    #end
    #if ((! $object.bukken_code) && ("$!object.bukken_code" == ""))
    #else
    #evaluate( "${esc.h}set( ${esc.d}bukken_area_${count_num} = ${esc.d}area )" )
    #evaluate( "${esc.h}set( ${esc.d}bukken_id_${count_num} = ${esc.d}object.bukken_code )" )
    #set($title = "#evaluate($object.buildingName)")
    #set($full_address = "#evaluate($object.address1)#evaluate($object.address2)#evaluate($object.address3)")
    #set($price = "#evaluate($object.price)万円")
    #if($object.busOnly1 == 1)
    #set($station_accsess = "#evaluate($object.railway1)「#evaluate($object.station1)」駅 バス#evaluate($object.busTime1)分 #evaluate($object.busStop1)下車 徒歩#evaluate($object.busWalk1)分")
    #else
    #set($station_accsess = "#evaluate($object.railway1)「#evaluate($object.station1)」駅 徒歩#evaluate($object.walk1)分")
    #end
    #evaluate( "${esc.h}set( ${esc.d}utm_term_${count_num} = ${esc.d}count_num )" )

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
    <table cellpadding="0" cellspacing="0" class="mktoModule" id="moduleSpace5" mktoName="空白１" border="0" align="center" style="border-collapse:separate;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;max-width:600px;margin:0 auto;background-color:#fbf8eb;padding:0 11%">
        <tbody>
            <tr style="max-width:600px;width:100%;">
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
                                        #if( $count_num == 1 )
                                        <a href="https://oh.openhouse-group.com/${bukken_area_1}/bukken/${bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param">
                                            <img width="100%" src="https://oh.openhouse-group.com/kanto/bukken/${bukken_id_1}/image/?size=L" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                        </a>
                                        #end
                                        #if( $count_num == 2 )
                                        <a href="https://oh.openhouse-group.com/${bukken_area_2}/bukken/${bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param">
                                            <img width="100%" src="https://oh.openhouse-group.com/kanto/bukken/${bukken_id_2}/image/?size=L" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                        </a>
                                        #end
                                        #if( $count_num == 3 )
                                        <a href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param">
                                            <img width="100%" src="https://oh.openhouse-group.com/kanto/bukken/${bukken_id_3}/image/?size=L" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                        </a>
                                        #end
                                        #if( $count_num == 4 )
                                        <a href="https://oh.openhouse-group.com/${bukken_area_4}/bukken/${bukken_id_4}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param">
                                            <img width="100%" src="https://oh.openhouse-group.com/kanto/bukken/${bukken_id_4}/image/?size=L" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                        </a>
                                        #end
                                        #if( $count_num == 5 )
                                        <a href="https://oh.openhouse-group.com/${bukken_area_5}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param">
                                            <img width="100%" src="https://oh.openhouse-group.com/kanto/bukken/${bukken_id_5}/image/?size=L" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                        </a>
                                        #end
                                        #if( $count_num == 6 )
                                        <a href="https://oh.openhouse-group.com/${bukken_area_6}/bukken/${bukken_id_6}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_6}&banner_id=${banner_id}$staff_id_param">
                                            <img width="100%" src="https://oh.openhouse-group.com/kanto/bukken/${bukken_id_6}/image/?size=L" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                        </a>
                                        #end
                                        #if( $count_num== 7 )
                                        <a href="https://oh.openhouse-group.com/${bukken_area_7}/bukken/${bukken_id_7}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=image&utm_content=${utm_content}&utm_term=property_0${utm_term_7}&banner_id=${banner_id}$staff_id_param">
                                            <img width="100%" src="https://oh.openhouse-group.com/kanto/bukken/${bukken_id_7}/image/?size=L" style="height:auto;backface-visibility: hidden; -webkit-backface-visibility: hidden;">
                                        </a>
                                        #end
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="padding: 0 7%;font-size: 16p;" class="title">
                                    #if( $count_num == 1 )
                                    <a href="https://oh.openhouse-group.com/${bukken_area_1}/bukken/${bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param">
                                        <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#215EAF;text-align: center;font-weight: 900;margin: 0;margin-top: 8px;">$title</p>
                                    </a>
                                    #end
                                    #if( $count_num == 2 )
                                    <a href="https://oh.openhouse-group.com/${bukken_area_2}/bukken/${bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param">
                                        <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#225EAF;text-align: center;font-weight: 900; margin: 0;margin-top: 8px;">$title</p>
                                    </a>
                                    #end
                                    #if( $count_num == 3 )
                                    <a href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param">
                                        <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#335EAF;text-align: center;font-weight: 900;margin: 0;margin-top: 8px;">$title</p>
                                    </a>
                                    #end
                                    #if( $count_num == 4 )
                                    <a href="https://oh.openhouse-group.com/${bukken_area_4}/bukken/${bukken_id_4}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param">
                                        <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.4em;background-color: #ffffff;color:#445EAF;text-align: center;font-weight: 900;margin: 0;margin-top: 8px;">$title</p>
                                    </a>
                                    #end
                                    #if( $count_num == 5 )
                                    <a href="https://oh.openhouse-group.com/${bukken_area_5}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param">
                                        <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.5em;background-color: #ffffff;color:#555EAF;text-align: center;font-weight: 900;margin: 0;margin-top: 8px;">$title</p>
                                    </a>
                                    #end
                                    #if( $count_num == 6 )
                                    <a href="https://oh.openhouse-group.com/${bukken_area_6}/bukken/${bukken_id_6}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param">
                                        <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.5em;background-color: #ffffff;color:#555EAF;text-align: center;font-weight: 900;margin: 0;margin-top: 8px;">$title</p>
                                    </a>
                                    #end
                                    #if( $count_num == 7 )
                                    <a href="https://oh.openhouse-group.com/${bukken_area_7}/bukken/${bukken_id_7}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=title&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param">
                                        <p style="font-size: 16px;mso-ansi-font-size:16px;line-height: 1.5em;background-color: #ffffff;color:#555EAF;text-align: center;font-weight: 900;margin: 0;margin-top: 8px;">$title</p>
                                    </a>
                                    #end
                                </td>
                            </tr>
                            <tr>
                                <td style="padding: 0 7%;font-size: 14px;" class="address">
                                    <p style="font-size: 14px;mso-ansi-font-size:14px;line-height: 1em;background-color: #ffffff;color:#000000;text-align: center;">#evaluate($full_address)<br>#evaluate($station_accsess)<br>#evaluate($price)</p>
                                </td>
                            </tr>
                            <tr style="table-layout:fixed">
                                <td class="left_btn" style="width: 46%;display: inline-table;margin-left: 4%;">
                                    #if( $count_num == 1 )
                                    <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_1}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 2 )
                                    <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_2}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 3 )
                                    <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_3}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 4 )
                                    <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_4}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 5 )
                                    <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_5}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 6 )
                                    <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_6}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_6}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 7 )
                                    <a href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_7}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_7}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--req" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: left;padding-right: 0.4em;mso-line-height-rule: exactly;">資料請求はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                </td>
                                <td class="right_btn" style="width: 46%;display: inline-table;margin-right: 4%">
                                    #if( $count_num == 1 )
                                    <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_1}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 2 )
                                    <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_2}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 3 )
                                    <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_3}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 4 )
                                    <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_4}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 5 )
                                    <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_5}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 6 )
                                    <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_6}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_6}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                    #if( $count_num == 7 )
                                    <a href="https://oh.openhouse-group.com/bukken/reserve/?bukken_id=${bukken_id_7}&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=res_btn_s&utm_content=${utm_content}&utm_term=property_0${utm_term_7}&banner_id=${banner_id}$staff_id_param" style="text-decoration:none;color: #215EAF;font-weight: 900; ">
                                        <p class="cta_link--kengaku" style="font-size: 0.8em;mso-ansi-font-size:0.8em;text-align: right;padding-left:0.4em;mso-line-height-rule: exactly;">見学予約はこちら&nbsp;<img style="vertical-align: middle;height:14px;min-height: 14px;max-height: 14px;vertical-align: text-bottom;" src="{%image.blue_arrow_right_2202%}"></p>
                                    </a>
                                    #end
                                </td>
                            </tr>
                            <tr>
                                <td align="center" style="border-radius: 5px;">
                                    #if( $count_num == 1 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_1}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:86%; text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 2 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_2}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:86%; text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 3 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_3}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:86%; text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 4 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_4}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_4}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:86%; text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 5 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_5}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_5}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:86%; text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 6 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_6}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_6}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_6}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_6}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:86%; text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 7 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_7}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_7}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#DA1A1D">
                                        <w:anchorlock/>
                                        <center style="color:#ffffff;font-family:sans-serif;font-size:13px;font-weight:bold;">図面を受け取る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/bukken/request/?bukken_id=${bukken_id_7}$staff_id_param&utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=req_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_7}&banner_id=${banner_id}" target="_blank" style="background-color: #DA1A1D;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;font-weight: bold;width:86%; text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 図面を受け取る</a>
                                    <!--<![endif]-->
                                    #end
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
                                    #if( $count_num == 1 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_1}/bukken/${bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                        <w:anchorlock/>
                                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_1}/bukken/${bukken_id_1}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_1}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:86% ;text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 2 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_2}/bukken/${bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                        <w:anchorlock/>
                                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_2}/bukken/${bukken_id_2}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_2}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:86% ;text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 3 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                        <w:anchorlock/>
                                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_3}/bukken/${bukken_id_3}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_3}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:86% ;text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 4 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_4}/bukken/${bukken_id_4}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                        <w:anchorlock/>
                                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_4}/bukken/${bukken_id_4}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_4}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:86% ;text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 5 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_5}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                        <w:anchorlock/>
                                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_5}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:86% ;text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 6 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_5}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                        <w:anchorlock/>
                                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_6}/bukken/${bukken_id_6}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_6}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:86% ;text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                    <!--<![endif]-->
                                    #end
                                    #if( $count_num == 7 )
                                    <!--[if gte mso | IE]>
                                    <v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://oh.openhouse-group.com/${bukken_area_5}/bukken/${bukken_id_5}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_5}&banner_id=${banner_id}$staff_id_param" style="height:70px;v-text-anchor:middle;width:300px;" arcsize="10%" strokecolor="#DA1A1D" fillcolor="#ffffff">
                                        <w:anchorlock/>
                                        <center style="color:#DA1A1D;font-family:sans-serif;font-size:13px;font-weight:bold;">詳しく見る</center>
                                    </v:roundrect>
                                    <![endif]-->
                                    <!--[if !gte !mso | !IE]><!-- -->
                                    <a class="main_cta" href="https://oh.openhouse-group.com/${bukken_area_7}/bukken/${bukken_id_7}/?utm_campaign=${utm_campaign}&utm_medium=${utm_medium}&utm_source=detail_btn&utm_content=${utm_content}&utm_term=property_0${utm_term_7}&banner_id=${banner_id}$staff_id_param" target="_blank" style="background-color: #fff;font-size: 14px; font-family: Helvetica, Arial, sans-serif; color: #DA1A1D; font-weight: bold;width:86% ;text-decoration: none;border-radius: 10px; padding: 16px 0; border: 1px solid #DA1A1D; display: inline-block;box-shadow: 1px 1px 4px #00000016;">▶︎ 詳しく見る</a>
                                    <!--<![endif]-->
                                    #end
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
    #set($count_num = $count_num + 1)
    #end
    #end
    <!-- Date if statement -->
    #end 