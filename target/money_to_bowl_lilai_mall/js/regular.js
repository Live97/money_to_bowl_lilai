//正则检验


/**
 * 手机号正则检验
 * @param phoneNumber
 * @returns {boolean}
 */
function validPhoneNumber(phoneNumber) {

    //手机号11位，第一位和第二位是有要求的，剩余9为是0-9数字
    var reg = /^1(3|4|5|6|7|8|9)\d{9}$/

    if (reg.test(phoneNumber)){
        return true;
    } else {
        return  false;
    }
}

/**
 * 密码正则检验，6-20位字符数字组合
 * @param password
 * @returns {boolean}
 */
function validPassword(password) {

    var reg = /^[a-zA-Z0-9]{6,20}$/
    if (reg.test(password.trim())) {
        return true;
    } else {
        return false;
    }
}

/**
 * 用户名正则检验 （4-16为字符数字，下划线，减号）
 * @param username
 * @returns {boolean}
 */
function validUsername(username) {

    var reg = /^[a-zA-Z0-9_-]{4,16}$/
    if (reg.test(username)) {
        return true;
    } else {
        return  false;
    }
}