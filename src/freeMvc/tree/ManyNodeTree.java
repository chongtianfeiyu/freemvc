/*
 * Copyright Walker Studio
 * All Rights Reserved.
 * 
 * 文件名称： ManyNodeTree.java
 * 摘 要：
 * 作 者： Walker
 * 创建时间： 2013-03-19
 */
package freeMvc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树生成、遍历工具
 * 
 * @author Walker
 * @version 1.0.0.0
 */
public class ManyNodeTree 
{
	/** 树根*/
	private ManyTreeNode root;
	
	/**
	 * 构造函数
	 */
	public ManyNodeTree()
	{
		root = new ManyTreeNode(new TreeNode("root"));
	}
	
	/**
	 * 生成一颗多叉树，根节点为root
	 * 
	 * @param treeNodes 生成多叉树的节点集合
	 * @return ManyNodeTree
	 */
	public ManyNodeTree createTree(List<TreeNode> treeNodes)
	{
		if(treeNodes == null || treeNodes.size() < 0)
			return null;
		
		ManyNodeTree manyNodeTree =  new ManyNodeTree();
		
		//将所有节点添加到多叉树中
		for(TreeNode treeNode : treeNodes)
		{
			if(treeNode.getParentId().equals("root"))
			{
				//向根添加一个节点
				manyNodeTree.getRoot().getChildList().add(new ManyTreeNode(treeNode));
			}
			else
			{
				addChild(manyNodeTree.getRoot(), treeNode);
			}
		}
		
		return manyNodeTree;
	}
	
	/**
	 * 向指定多叉树节点添加子节点
	 * 
	 * @param manyTreeNode 多叉树节点
	 * @param child 节点
	 */
	public void addChild(ManyTreeNode manyTreeNode, TreeNode child)
	{
		for(ManyTreeNode item : manyTreeNode.getChildList())
		{
			if(item.getData().getNodeId().equals(child.getParentId()))
			{
				//找到对应的父亲
				item.getChildList().add(new ManyTreeNode(child));
				break;
			}
			else
			{
				if(item.getChildList() != null && item.getChildList().size() > 0)
				{
					addChild(item, child);
				}				
			}
		}
	}
	
	/**
	 * 遍历多叉树 
	 * 
	 * @param manyTreeNode 多叉树节点
	 * @return 
	 */
	public String iteratorTree(ManyTreeNode manyTreeNode)
	{
		StringBuilder buffer = new StringBuilder();
		buffer.append("\n");
		
		if(manyTreeNode != null) 
		{	
			for (ManyTreeNode index : manyTreeNode.getChildList()) 
			{
				buffer.append(index.getData().getNodeId()+ ",");
				
				if (index.getChildList() != null && index.getChildList().size() > 0 ) 
				{	
					buffer.append(iteratorTree(index));
				}
			}
		}
		
		buffer.append("\n");
		
		return buffer.toString();
	}
	
	public ManyTreeNode getRoot() {
		return root;
	}

	public void setRoot(ManyTreeNode root) {
		this.root = root;
	}
	
	public static void main(String[] args)
	{
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
			treeNodes.add(new TreeNode("饮食男女", "root"));
			treeNodes.add(new TreeNode("美食俱乐部", "饮食男女"));
			treeNodes.add(new TreeNode("我为零食狂", "饮食男女"));
			treeNodes.add(new TreeNode("秀美食", "美食俱乐部"));
			treeNodes.add(new TreeNode("年夜饭", "美食俱乐部"));
			treeNodes.add(new TreeNode("拉风汽车", "root"));
			treeNodes.add(new TreeNode("拉风大本营", "拉风汽车"));
			treeNodes.add(new TreeNode("二手车", "拉风汽车"));
			
			ManyNodeTree tree = new ManyNodeTree();
			
			System.out.println(tree.iteratorTree(tree.createTree(treeNodes).getRoot()));
	}
	
}
