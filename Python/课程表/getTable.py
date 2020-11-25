from bs4 import BeautifulSoup
import requests
import base64
import re
'''
dict={'userAccount': '190206134','userPassword': '','encoded': 'MTkwMjA2MTM0%%%d2FuZ2JvMTIz'}
dict2={'rq': '2020-12-01'}
cookieUrl = 'http://172.16.247.230:800/jsxsd/xk/172.16.52.2:800/logout?service=http%3A%2F%2F172.16.247.230%3A800%2Fjsxsd'
loginCookieHeader = requests.get(cookieUrl)
cookieHeader = requests.utils.dict_from_cookiejar(loginCookieHeader.cookies)
headers = {
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
    'Accept-Encoding': 'gzip, deflate',
    'Accept-Language': 'zh-CN,zh;q=0.9',
    'Cache-Control': 'max-age=0',
    'Connection': 'keep-alive',
    'Content-Length': '77',
    'Content-Type': 'application/x-www-form-urlencoded',
    'Cookie': 'JSESSIONID='+cookieHeader['JSESSIONID']+'; JSESSIONID=AD2FD58CB77124D425E47FFE8FEB6014',
    'Host': '172.16.247.230:800',
    'Origin': 'http://172.16.247.230:800',
    'Referer': 'http://172.16.247.230:800/jsxsd/xk/LoginToXk',
    'Upgrade-Insecure-Requests': '1',
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36'}
r = requests.post(url='http://172.16.247.230:800/jsxsd/xk/LoginToXk', data=dict, headers=headers)
'''
#r2 = requests.post(url='http://172.16.247.230:800/jsxsd/framework/main_index_loadkb.jsp', data=dict2, headers=headers)
#print(r2.text)
#soup = BeautifulSoup(r2.text.replace('<br/>','[enter]').replace('\t','').replace('\r\n','').replace("'",'"'), 'lxml')
#timeTable = [[],[],[],[],[],[],[]]
#for th in soup.table.thead.tr.find_all():
#    timeTable[0].append(th.string)
#i = 0
#j = 0
#for tr in soup.table.tbody.find_all('tr'):
#    i += 1
#    for td in tr.find_all('td'):
#        j += 1
#        if td.string == None:
#            timeTable[i].append(None)
#        elif j == 1:
#            timeTable[i].append(td.string)
#        else:
#            d = {}
#            for item in td.p['title'].split('[enter]'):
#                d[item[:4]] = item[5:]
#            timeTable[i].append(d)

#    j = 0




class tableFun:
    def __init__(self, day):
        self.day = day
        self.loginHeader = {}

    def login(self):#登录获取cookie
        #登录的账号密码
        dict = {'userAccount': '190206134', 'userPassword': '', 'encoded': 'MTkwMjA2MTM0%%%d2FuZ2JvMTIz'}
        #得到每次登录所需要的cookie
        cookieUrl = 'http://172.16.247.230:800/jsxsd/xk/172.16.52.2:800/logout?service=http%3A%2F%2F172.16.247.230%3A800%2Fjsxsd'
        loginCookieHeader = requests.get(cookieUrl)
        cookieHeader = requests.utils.dict_from_cookiejar(loginCookieHeader.cookies)
        #登录的头文件
        headers = {
            'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
            'Accept-Encoding': 'gzip, deflate',
            'Accept-Language': 'zh-CN,zh;q=0.9',
            'Cache-Control': 'max-age=0',
            'Connection': 'keep-alive',
            'Content-Length': '77',
            'Content-Type': 'application/x-www-form-urlencoded',
            'Cookie': 'JSESSIONID=' + cookieHeader['JSESSIONID'] + '; JSESSIONID=AD2FD58CB77124D425E47FFE8FEB6014',#处理cookie
            'Host': '172.16.247.230:800',
            'Origin': 'http://172.16.247.230:800',
            'Referer': 'http://172.16.247.230:800/jsxsd/xk/LoginToXk',
            'Upgrade-Insecure-Requests': '1',
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36'}

        r = requests.post(url='http://172.16.247.230:800/jsxsd/xk/LoginToXk', data=dict, headers=headers)#登录
        if r.text == '':#登录成功返回True,把请求头给类属性
            self.loginHeader = headers
            return True
        else:
            return False


    def getData(self, date):#获取课程表
        dict2 = {'rq': date}
        r2 = requests.post(url='http://172.16.247.230:800/jsxsd/framework/main_index_loadkb.jsp', data=dict2, headers=self.loginHeader)#获取课程表包
        soup = BeautifulSoup(r2.text.replace('<br/>','[enter]').replace('\t','').replace('\r\n','').replace("'",'"'), 'lxml')#数据处理转换为beautifulsoup格式进行处理
        timeTable = [[], [], [], [], [], [], []]#建立一个二维列表
        f = open('Table.txt','w+')
        for th in soup.table.thead.tr.find_all():#获取列表头（周一周二...）
            timeTable[0].append(th.string)
        f.write(",".join(timeTable[0]))
        i,j = 0,0
        for tr in soup.table.tbody.find_all('tr'):#遍历六个大节
            i += 1
            for td in tr.find_all('td'):#遍历每天
                j += 1
                if td.string == None:  # 若为None置为-，即没课
                    timeTable[i].append("-")
                elif j == 1:#若为行表头直接取string值
                    timeTable[i].append(td.string)
                else:
                    #d = {}#建立一个空字典用于存储有课的数据
                    #for item in td.p['title'].split('[enter]'):#保存每项属性
                    #    d[item[:4]] = item[5:]
                    timeTable[i].append(td.p['title'])#添加到列表
            j = 0
            print(timeTable[i])
            f.write('\n'+",".join(timeTable[i]))
        f.close()
    def readTable(self):
        timeTable = [[], [], [], [], [], [], []]  # 建立一个二维列表
        with open('Table.txt','r+') as f:
            for line in f:
                for value in line.split(','):
                    if value == '-':
                        timeTable.append(None)
                    elif re.findall("第\S大节",value)!=[]:
                        timeTable.append(value.replace('[enter]', '\n'))
                    else:
                        d = {}#建立一个空字典用于存储有课的数据
                        for item in td.p['title'].split('[enter]'):#保存每项属性
                            d[item[:4]] = item[5:]


t=tableFun('2020-11-24')
print(t.login())
t.getData('2020-11-24')