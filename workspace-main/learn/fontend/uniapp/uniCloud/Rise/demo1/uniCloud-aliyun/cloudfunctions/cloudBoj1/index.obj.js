// 云对象教程: https://uniapp.dcloud.net.cn/uniCloud/cloud-obj
// jsdoc语法提示教程：https://ask.dcloud.net.cn/docs/#//ask.dcloud.net.cn/article/129

const db = uniCloud.database()

module.exports = {
	_before: function () { // 通用预处理器

	},
	async get(num) {
		return await db.collection('article').limit(num).get()
	},
	async add() {
		return await db.collection('article').add({
			title: '测试标题',
			content: '测试内容'
		})
	}
}
