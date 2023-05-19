//获取富文本内的图片url地址
export function getImgSrc(richtext, num = 3) {
	let imgList = [];
	richtext.replace(/<img [^>]*src=['"]([^'"]+)[^>]*>/g, (match, capture) => {
		imgList.push(capture);
	});
	imgList = imgList.slice(0, num)
	return imgList;
}

export function getProvince() {
	return new Promise((resolve, reject) => {
		let history = uni.getStorageSync('historyProvince')
		if (history) {
			if ((Date.now() - history.time) > 1000 * 60 * 60) {
				getIp().then(res => {
					resolve(res)
				}).catch(err => {
					reject(err)
				})
			} else {
				resolve(history.province)
			}
		} else {
			getIp().then(res => {
				resolve(res)
			}).catch(err => {
				reject(err)
			})
		}
	})
}

function getIp() {
	return new Promise((resolve, reject) => {
		uni.request({
			url: 'https://restapi.amap.com/v3/ip?key=44defa63909408d7bc63f19df5ac978f',
			success: res => {
				let str = ''
				if (typeof(res.data.province) === 'string') {
					str = res.data.province
				} else {
					str = '火星'
				}
				resolve(str)
				let obj = {
					province: str,
					time: Date.now()
				}
				uni.setStorageSync('historyProvince', obj)
			},
			fail: err => {
				reject(err)
			}
		})
	})
}
