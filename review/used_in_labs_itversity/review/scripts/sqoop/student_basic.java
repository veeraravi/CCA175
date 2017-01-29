// ORM class for table 'student_basic'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Fri Jan 20 07:09:13 EST 2017
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class student_basic extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("SID", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        SID = (Integer)value;
      }
    });
    setters.put("sname", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        sname = (String)value;
      }
    });
    setters.put("sage", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        sage = (Integer)value;
      }
    });
    setters.put("ssex", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ssex = (String)value;
      }
    });
  }
  public student_basic() {
    init0();
  }
  private Integer SID;
  public Integer get_SID() {
    return SID;
  }
  public void set_SID(Integer SID) {
    this.SID = SID;
  }
  public student_basic with_SID(Integer SID) {
    this.SID = SID;
    return this;
  }
  private String sname;
  public String get_sname() {
    return sname;
  }
  public void set_sname(String sname) {
    this.sname = sname;
  }
  public student_basic with_sname(String sname) {
    this.sname = sname;
    return this;
  }
  private Integer sage;
  public Integer get_sage() {
    return sage;
  }
  public void set_sage(Integer sage) {
    this.sage = sage;
  }
  public student_basic with_sage(Integer sage) {
    this.sage = sage;
    return this;
  }
  private String ssex;
  public String get_ssex() {
    return ssex;
  }
  public void set_ssex(String ssex) {
    this.ssex = ssex;
  }
  public student_basic with_ssex(String ssex) {
    this.ssex = ssex;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof student_basic)) {
      return false;
    }
    student_basic that = (student_basic) o;
    boolean equal = true;
    equal = equal && (this.SID == null ? that.SID == null : this.SID.equals(that.SID));
    equal = equal && (this.sname == null ? that.sname == null : this.sname.equals(that.sname));
    equal = equal && (this.sage == null ? that.sage == null : this.sage.equals(that.sage));
    equal = equal && (this.ssex == null ? that.ssex == null : this.ssex.equals(that.ssex));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof student_basic)) {
      return false;
    }
    student_basic that = (student_basic) o;
    boolean equal = true;
    equal = equal && (this.SID == null ? that.SID == null : this.SID.equals(that.SID));
    equal = equal && (this.sname == null ? that.sname == null : this.sname.equals(that.sname));
    equal = equal && (this.sage == null ? that.sage == null : this.sage.equals(that.sage));
    equal = equal && (this.ssex == null ? that.ssex == null : this.ssex.equals(that.ssex));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.SID = JdbcWritableBridge.readInteger(1, __dbResults);
    this.sname = JdbcWritableBridge.readString(2, __dbResults);
    this.sage = JdbcWritableBridge.readInteger(3, __dbResults);
    this.ssex = JdbcWritableBridge.readString(4, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.SID = JdbcWritableBridge.readInteger(1, __dbResults);
    this.sname = JdbcWritableBridge.readString(2, __dbResults);
    this.sage = JdbcWritableBridge.readInteger(3, __dbResults);
    this.ssex = JdbcWritableBridge.readString(4, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(SID, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(sname, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(sage, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(ssex, 4 + __off, 12, __dbStmt);
    return 4;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(SID, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(sname, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(sage, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(ssex, 4 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.SID = null;
    } else {
    this.SID = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.sname = null;
    } else {
    this.sname = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.sage = null;
    } else {
    this.sage = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.ssex = null;
    } else {
    this.ssex = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.SID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.SID);
    }
    if (null == this.sname) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sname);
    }
    if (null == this.sage) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.sage);
    }
    if (null == this.ssex) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ssex);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.SID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.SID);
    }
    if (null == this.sname) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sname);
    }
    if (null == this.sage) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.sage);
    }
    if (null == this.ssex) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ssex);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(SID==null?"null":"" + SID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sname==null?"null":sname, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sage==null?"null":"" + sage, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ssex==null?"null":ssex, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(SID==null?"null":"" + SID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sname==null?"null":sname, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sage==null?"null":"" + sage, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ssex==null?"null":ssex, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.SID = null; } else {
      this.SID = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.sname = null; } else {
      this.sname = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sage = null; } else {
      this.sage = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ssex = null; } else {
      this.ssex = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.SID = null; } else {
      this.SID = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.sname = null; } else {
      this.sname = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sage = null; } else {
      this.sage = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ssex = null; } else {
      this.ssex = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    student_basic o = (student_basic) super.clone();
    return o;
  }

  public void clone0(student_basic o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("SID", this.SID);
    __sqoop$field_map.put("sname", this.sname);
    __sqoop$field_map.put("sage", this.sage);
    __sqoop$field_map.put("ssex", this.ssex);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("SID", this.SID);
    __sqoop$field_map.put("sname", this.sname);
    __sqoop$field_map.put("sage", this.sage);
    __sqoop$field_map.put("ssex", this.ssex);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
