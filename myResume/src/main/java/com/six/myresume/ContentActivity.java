package com.six.myresume;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.idunnololz.widgets.AnimatedExpandableListView;
import com.idunnololz.widgets.AnimatedExpandableListView.AnimatedExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContentActivity extends Activity {

	private ExampleAdapter adapter;
	private AnimatedExpandableListView listView;
	ActionBar actionBar = null;
	TextView actionTitle;
	// 定义组颜色
	int[] colorInt = { R.drawable.purple_me, R.drawable.orange_me,
			R.drawable.red_me, R.drawable.green_me, R.drawable.bule_me };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		actionBar = getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setCustomView(R.layout.actionbar_main);// 自定义ActionBar布局
		actionTitle = (TextView) actionBar.getCustomView().findViewById(
				R.id.ActionBarTitle);
		// 设置返回监听
		actionBar.getCustomView().findViewById(R.id.action_back)
				.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						onBackPressed();// 返回
					}
				});

		List<GroupItem> items;
		int id = getIntent().getIntExtra("id", 0);
		switch (id) {
			case 1:
				items = getAboutMe();
				break;
			case 2:
				items = getMyObject();
				break;

			case 3:
				items = getAwards();
				break;

			case 4:
				items = getCertificate();
				break;

			default:
				items = new ArrayList<GroupItem>();
				break;
		}

		adapter = new ExampleAdapter(this);
		adapter.setData(items);

		listView = (AnimatedExpandableListView) findViewById(R.id.lv);

		listView.setAdapter(adapter);
		listView.setGroupIndicator(null);// 设置取消原本的展开箭头
		// 设置list监听器
		listView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
										int groupPosition, long id) {
				if (listView.isGroupExpanded(groupPosition)) {// 关闭列表
					listView.collapseGroupWithAnimation(groupPosition);
					// Toast.makeText(getApplicationContext(), "关闭列表",Toast.LENGTH_SHORT).show();
				} else {
					listView.expandGroupWithAnimation(groupPosition);// 打开列表
					// Toast.makeText(getApplicationContext(), "打开列表",Toast.LENGTH_SHORT).show();
				}
				return true;
			}

		});

		// 设置第一组默认展开
		if(id != 4){
			listView.expandGroupWithAnimation(0);
		};
	}

	// 我定义的

	public List<GroupItem> getAboutMe() {// 关于我
		actionTitle.setText("我的资料");
		List<GroupItem> items = new ArrayList<GroupItem>();
		GroupItem item = new GroupItem();

		item.title = "基本资料";
		ChildItem child = new ChildItem();
		child.title = "年龄：21岁\n性别：男\n身份：共青团员\n民族：汉族\n籍贯：广东茂名\n居住地：广东广州";
		item.items.add(child);
		items.add(item);

		GroupItem item2 = new GroupItem();
		item2.title = "个人介绍";
		ChildItem child21 = new ChildItem();
		child21.title = "本人积极向上，认真负责，对有安卓开发有深厚兴趣并有不错的技术基础，并且有良好的编程习惯。\n在班上担任班长，能很好的处理与周围人的关系，迅速融入集体，能够很快适应各种工作生活。";
		item2.items.add(child21);
		items.add(item2);

		GroupItem item3 = new GroupItem();
		item3.title = "职业技能";
		ChildItem child31 = new ChildItem();
		child31.title = "能熟练使用Eclipse、Android Studio、AppCan、HBuilder等开发软件";
		item3.items.add(child31);
		ChildItem child32 = new ChildItem();
		child32.title = "熟练掌握java语言，熟悉面向对象编程设计，具有良好的编程习惯";
		item3.items.add(child32);
		ChildItem child33 = new ChildItem();
		child33.title = "熟悉mysql，Sql Server等主流数据库，掌握数据库增删改查等操作";
		item3.items.add(child33);
		items.add(item3);
		return items;
	}

	public List<GroupItem> getMyObject() {
		actionTitle.setText("参与项目");
		List<GroupItem> items = new ArrayList<GroupItem>();

		GroupItem item0 = new GroupItem();
		item0.title = "云大学（Java C/S） ";
		ChildItem child0 = new ChildItem();
		child0.title = "使用Java C/S模式";
		item0.items.add(child0);
		ChildItem child01 = new ChildItem();
		child01.title = "采用MVC结构，连接MySql，封装Dao层，动态显示内容与数据";
		item0.items.add(child01);
		items.add(item0);

		GroupItem item1 = new GroupItem();
		item1.title = "我的大学（Java B/S） ";
		ChildItem child1 = new ChildItem();
		child1.title = "使用Java B/S模式";
		item1.items.add(child1);
		ChildItem child12 = new ChildItem();
		child12.title = "除了与C/S版本模式上的区别外，B/S版本根据用户使用习惯优化，使用户更加便利、清晰的使用本程序中的功能";
		item1.items.add(child12);
		items.add(item1);

		GroupItem item = new GroupItem();
		item.title = "简易计算器（Android） ";
		ChildItem child = new ChildItem();
		child.title = "实现加减乘除运算，支持显示计算公式";
		item.items.add(child);
		items.add(item);

		GroupItem item2 = new GroupItem();
		item2.title = "体重管家（Android）";
		ChildItem child21 = new ChildItem();
		child21.title = "实现根据用户选择条件计算体重等级，并给出相应建议";
		item2.items.add(child21);
		items.add(item2);

		GroupItem item3 = new GroupItem();
		item3.title = "跳跳跳（Android游戏）";
		ChildItem child31 = new ChildItem();
		child31.title = "实现角色动态绘制、重力传感器控制角色移动，支持平滑控制";
		item3.items.add(child31);
		items.add(item3);

		GroupItem item4 = new GroupItem();
		item4.title = "孩儿宝（Android）";
		ChildItem child41 = new ChildItem();
		child41.title = "实现从json动态加载数据";
		item4.items.add(child41);
		ChildItem child42 = new ChildItem();
		child42.title = "实现了侧滑菜单等流行交互方式";
		item4.items.add(child42);
		ChildItem child43 = new ChildItem();
		child43.title = "实现录音、播放预设声音或者客户录音、sd卡文件操作等";
		item4.items.add(child43);
		items.add(item4);

		GroupItem item5 = new GroupItem();
		item5.title = "我的个人简历（Android）";
		ChildItem child51 = new ChildItem();
		child51.title = "使用AnimatedExpandableListView开源库";
		item5.items.add(child51);
		ChildItem child52 = new ChildItem();
		child52.title = "自定义ActionBar，并重新美化AnimatedExpandableListView";
		item5.items.add(child52);
		ChildItem child53 = new ChildItem();
		child53.title = "跳转Activity动态传递参数改变布局，适应多种分辨率设备";
		item5.items.add(child53);
		ChildItem child54 = new ChildItem();
		child54.title = "采用Intent调用系统电话、信息等接口，并利用剪贴板临时保存数据。";
		item5.items.add(child54);
		items.add(item5);

		GroupItem item6 = new GroupItem();
		item6.title = "工程学院商城（混合模式）";
		ChildItem child61 = new ChildItem();
		child61.title = "使用HTML5+Android的混合开发模式，使用腾讯X5浏览内核。模仿手机京东APP。";
		item6.items.add(child61);
		items.add(item6);

		GroupItem item7 = new GroupItem();
		item7.title = "公文传阅系统（小组项目）";
		ChildItem child71 = new ChildItem();
		child71.title = "小组成员共两人";
		item7.items.add(child71);
		ChildItem child72 = new ChildItem();
		child72.title = "本人负责后端开发与数据库结构设计，使用Struts2、Hibernate等框架技术。";
		item7.items.add(child72);
		items.add(item7);

		return items;
	}

	public List<GroupItem> getAwards() {
		actionTitle.setText("在校情况");
		List<GroupItem> items = new ArrayList<GroupItem>();
		GroupItem item = new GroupItem();

		item.title = "教育情况 ";
		ChildItem child = new ChildItem();
		child.title = "2014.09至今\n广州工程职业技术学院\n专业：计算机应用技术（企业信息管理师）";
		item.items.add(child);
		ChildItem child12 = new ChildItem();
		child12.title = "主要课程：\n\t\t\t\tJavaWeb开发技术、";
		item.items.add(child12);
		ChildItem child13 = new ChildItem();
		child13.title = "\t\t\t\t企业级软件项目开发、";
		item.items.add(child13);
		ChildItem child14 = new ChildItem();
		child14.title = "\t\t\t\tJava软件项目综合开发、";
		item.items.add(child14);
		ChildItem child15 = new ChildItem();
		child15.title = "\t\t\t\t移动应用项目开发(Android)";
		item.items.add(child15);
		ChildItem child16 = new ChildItem();
		child16.title = "\t\t\t\tAndroid开发实训";
		item.items.add(child16);
		items.add(item);

		GroupItem item2 = new GroupItem();
		item2.title = "学生职务";
		ChildItem child21 = new ChildItem();
		child21.title = "14级计算机应用技术（企业信息管理师）     班长";
		item2.items.add(child21);
		ChildItem child22 = new ChildItem();
		child22.title = "院学生大学生教学设备运行服务大队      技术部部长";
		item2.items.add(child22);
		ChildItem child23 = new ChildItem();
		child23.title = "院学生会网络检测服务站（2014 - 2015）     干事 ";
		item2.items.add(child23);
		items.add(item2);

		GroupItem item3 = new GroupItem();
		item3.title = "在校获奖";
		ChildItem child31 = new ChildItem();
		child31.title = "军训优秀标兵（2014）";
		item3.items.add(child31);
		ChildItem child32 = new ChildItem();
		child32.title = "院学生会优秀干事（2014）";
		item3.items.add(child32);
		ChildItem child33 = new ChildItem();
		child33.title = "优秀学生二等奖";
		item3.items.add(child33);
		ChildItem child34 = new ChildItem();
		child34.title = "学生干部标兵";
		item3.items.add(child34);
		ChildItem child35 = new ChildItem();
		child35.title = "国家励志奖学金";
		item3.items.add(child35);
		ChildItem child36 = new ChildItem();
		child36.title = "院学生会优秀干部";
		item3.items.add(child36);
		items.add(item3);

		return items;
	}

	public List<GroupItem> getCertificate() {
		actionTitle.setText("资格证书");
		List<GroupItem> items = new ArrayList<GroupItem>();
		GroupItem item = new GroupItem();

		item.title = "计算机等级考试二级证书（JAVA语言程序设计） ";
		ChildItem child = new ChildItem();
		child.title = "全国计算机等级考试（National Computer Rank Examination，以下简称 NCRE），是经原国家教育委员会（现教育部）批准，由教育部考试中心主办。";
		item.items.add(child);
		ChildItem child1 = new ChildItem();
		child1.title = "NCRE 考试采用全国统一命题，统一考试的形式。所有科目每年开考两次。NCRE 不以评价教学为目的，考核内容不是按照学校要求设定，而是根据社会不同部门应用计算机的不同程度和需要、国内计算机技术的发展情况以及中国计算机教育、教学和普及的现状而确定的";
		item.items.add(child1);
		ChildItem child2 = new ChildItem();
		child2.title = "它以应用能力为主，划分等级，分别考核，为人员择业、人才流动提供其计算机应用知识与能力水平的证明";
		item.items.add(child2);
		items.add(item);

		GroupItem item2 = new GroupItem();
		item2.title = "Google Android StudyJam China 结业证书";
		ChildItem child21 = new ChildItem();
		child21.title = "Study Jams 是一个学习 Google 在线课程的活动。该活动由学员自发组建课程学习小组，旨在带领小组成员入门 Android 开发，最终将 Android App 上载至 Google Play 并与他人分享自己的学习历程";
		item2.items.add(child21);
		ChildItem child22 = new ChildItem();
		child22.title = "参加 StudyJams 活动并顺利完成课程提交apk并由谷歌官方审核通过的学习者将获得此证书。";
		item2.items.add(child22);
		items.add(item2);

		return items;
	}

	// 附加
	private static class GroupItem {
		String title;
		List<ChildItem> items = new ArrayList<ChildItem>();
	}

	private static class ChildItem {
		String title;
		// String hint;
	}

	private static class ChildHolder {
		TextView title;
		// TextView hint;
	}

	private static class GroupHolder {
		TextView title;
		public ImageView arrow;
	}

	/**
	 * Adapter for our list of {@link GroupItem}s.
	 */
	private class ExampleAdapter extends AnimatedExpandableListAdapter {
		private LayoutInflater inflater;

		private List<GroupItem> items;

		public ExampleAdapter(Context context) {
			inflater = LayoutInflater.from(context);
		}

		public void setData(List<GroupItem> items) {
			this.items = items;
		}

		@Override
		public ChildItem getChild(int groupPosition, int childPosition) {
			return items.get(groupPosition).items.get(childPosition);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getRealChildView(int groupPosition, int childPosition,
									 boolean isLastChild, View convertView, ViewGroup parent) {
			ChildHolder holder;
			ChildItem item = getChild(groupPosition, childPosition);
			if (convertView == null) {
				holder = new ChildHolder();
				convertView = inflater.inflate(R.layout.list_item_me, parent,
						false);
				holder.title = (TextView) convertView
						.findViewById(R.id.textTitle);
				// holder.hint = (TextView)
				// convertView.findViewById(R.id.textHint);
				convertView.setTag(holder);
			} else {
				holder = (ChildHolder) convertView.getTag();
			}

			holder.title.setText(item.title);
			// holder.hint.setText(item.hint);

			return convertView;
		}

		@Override
		public int getRealChildrenCount(int groupPosition) {
			return items.get(groupPosition).items.size();
		}

		@Override
		public GroupItem getGroup(int groupPosition) {
			return items.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			return items.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
								 View convertView, ViewGroup parent) {
			GroupHolder holder;
			GroupItem item = getGroup(groupPosition);
			if (convertView == null) {
				holder = new GroupHolder();
				convertView = inflater.inflate(R.layout.group_item_me, parent,
						false);
				// 设置组颜色
				convertView.setBackground(getResources().getDrawable(
						colorInt[groupPosition % 5]));

				holder.title = (TextView) convertView
						.findViewById(R.id.textTitle);
				holder.arrow = (ImageView) convertView
						.findViewById(R.id.question_arrow_iv);
				convertView.setTag(holder);
			} else {
				holder = (GroupHolder) convertView.getTag();
			}

			holder.title.setText(item.title);
			// 通过判断组的开合状态改变箭头样式
			if (isExpanded) {
				holder.arrow.setBackgroundResource(R.drawable.closed);
			} else {
				holder.arrow.setBackgroundResource(R.drawable.opened);
			}
			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public boolean isChildSelectable(int arg0, int arg1) {
			return true;
		}

	}
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
