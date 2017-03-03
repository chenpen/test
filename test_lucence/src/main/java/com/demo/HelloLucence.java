package com.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.FieldCache.Parser;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public class HelloLucence {
	/**
	 * 建立索引
	 */
	public void index() {
		// 创建Directory(在内存中)
		// Directory directory=new RAMDirectory();
		// 在硬盘上创建
		Directory directory = null;
		try {
			directory = FSDirectory.open(new File("D:/lucence/index01"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 创建indexWriter
		IndexWriterConfig inwconfig = new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35));
		IndexWriter inw = null;
		try {
			inw = new IndexWriter(directory, inwconfig);
			// 创建document

			File lucenceDir = new File("D:/lucence/File");
			for (File file : lucenceDir.listFiles()) {
				Document doc = new Document();
				// 创建内容为store
				// System.out.println(FileUtils.readFileToString(file,"UTF-8"));
				// doc.add(new
				// Field("content",FileUtils.readFileToString(file,"UTF-8"),
				// Field.Store.YES,Field.Index.NOT_ANALYZED));
				doc.add(new Field("content", new FileReader(file)));
				doc.add(new Field("fileName", file.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
				doc.add(new Field("path", file.getAbsolutePath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
				inw.addDocument(doc);
			}

			// 为document创建Field
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/**
	 * 更新（删除并添加，没有匹配的更新选项也会删除，然后添加）
	 */
	public void update() {
		Directory directory = null;
		try {
			directory = FSDirectory.open(new File("D:/lucence/index01"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 创建indexWriter
		IndexWriterConfig inwconfig = new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35));
		IndexWriter inw = null;
		try {
			inw = new IndexWriter(directory, inwconfig);
			Document doc=new Document();
			File file=new File("D:/lucence/File/test1.txt");
			doc.add(new Field("content", new FileReader(file)));
			doc.add(new Field("fileName", file.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
			doc.add(new Field("path", file.getAbsolutePath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
			inw.updateDocument(new Term("fileName","test1.txt"),doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				inw.close();
			} catch (CorruptIndexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 查询
	 * 
	 * @throws IOException
	 */
	public void query()  {
		IndexReader reader = null;
		// 1.创建Directory
		Directory directory;
		try {
			directory = FSDirectory.open(new File("D:/lucence/index01"));
			// 2.创建IndexReader
			reader = IndexReader.open(directory);
			System.out.println("numDelete:"+reader.numDeletedDocs());
			System.out.println("numdoc:"+reader.numDocs());
			System.out.println("maxdoc:"+reader.maxDoc());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 恢复删除
	 */
	public void undelete(){
		IndexReader reader=null;
		try{
			// 1.创建Directory
			Directory directory = FSDirectory.open(new File("D:/lucence/index01"));
			// 2.创建IndexReader
			reader = IndexReader.open(directory,false);
			reader.undeleteAll();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	/**
	 * 删除索引(并不会真正的删除，删除的部分会在回收站中)
	 */
	public void delete() {
		Directory directory = null;
		try {
			directory = FSDirectory.open(new File("D:/lucence/index01"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 创建indexWriter
		IndexWriterConfig inwconfig = new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35));
		IndexWriter inw = null;
		try {
			inw = new IndexWriter(directory, inwconfig);
			inw.deleteDocuments(new Term("fileName","test1.txt"));
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				inw.close();
			} catch (CorruptIndexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 搜索
	 */
	public void searcher(String searchStr) {
		IndexReader reader = null;
		try {
			// 1.创建Directory
			Directory directory = FSDirectory.open(new File("D:/lucence/index01"));
			// 2.创建IndexReader
			reader = IndexReader.open(directory);
			// 3,根据searcher 创建 indexSearch
			IndexSearcher searcher = new IndexSearcher(reader);
			// 4,创建parser
			// 创建parser来确定要搜索的文件的内容，第二个参数表示搜索的域
			QueryParser parser = new QueryParser(Version.LUCENE_35, "content", new StandardAnalyzer(Version.LUCENE_35));
			Query query = parser.parse(searchStr);
			// 5.根据searcher搜索并且返回TopDOCs
			TopDocs topDocs = searcher.search(query, 10);
			// 6.根据TOPDocs 获取ScoreDoc对象
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			// 7,根据seracher和Scoredoc对象获取具体的Documnet对象
			for (ScoreDoc scoreDoc : scoreDocs) {
				Document doc = searcher.doc(scoreDoc.doc);
				// 8，根据Document对象获取需要的值
				System.out.println(doc.get("fileName"));
			}
			// 9，关闭reader
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
