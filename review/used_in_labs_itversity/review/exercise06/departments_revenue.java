// ORM class for table 'departments_revenue'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sat Jan 14 19:43:31 EST 2017
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

public class departments_revenue extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("order_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        order_date = (String)value;
      }
    });
    setters.put("department_name", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        department_name = (String)value;
      }
    });
    setters.put("revenuce", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        revenuce = (java.math.BigDecimal)value;
      }
    });
  }
  public departments_revenue() {
    init0();
  }
  private String order_date;
  public String get_order_date() {
    return order_date;
  }
  public void set_order_date(String order_date) {
    this.order_date = order_date;
  }
  public departments_revenue with_order_date(String order_date) {
    this.order_date = order_date;
    return this;
  }
  private String department_name;
  public String get_department_name() {
    return department_name;
  }
  public void set_department_name(String department_name) {
    this.department_name = department_name;
  }
  public departments_revenue with_department_name(String department_name) {
    this.department_name = department_name;
    return this;
  }
  private java.math.BigDecimal revenuce;
  public java.math.BigDecimal get_revenuce() {
    return revenuce;
  }
  public void set_revenuce(java.math.BigDecimal revenuce) {
    this.revenuce = revenuce;
  }
  public departments_revenue with_revenuce(java.math.BigDecimal revenuce) {
    this.revenuce = revenuce;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof departments_revenue)) {
      return false;
    }
    departments_revenue that = (departments_revenue) o;
    boolean equal = true;
    equal = equal && (this.order_date == null ? that.order_date == null : this.order_date.equals(that.order_date));
    equal = equal && (this.department_name == null ? that.department_name == null : this.department_name.equals(that.department_name));
    equal = equal && (this.revenuce == null ? that.revenuce == null : this.revenuce.equals(that.revenuce));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof departments_revenue)) {
      return false;
    }
    departments_revenue that = (departments_revenue) o;
    boolean equal = true;
    equal = equal && (this.order_date == null ? that.order_date == null : this.order_date.equals(that.order_date));
    equal = equal && (this.department_name == null ? that.department_name == null : this.department_name.equals(that.department_name));
    equal = equal && (this.revenuce == null ? that.revenuce == null : this.revenuce.equals(that.revenuce));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.order_date = JdbcWritableBridge.readString(1, __dbResults);
    this.department_name = JdbcWritableBridge.readString(2, __dbResults);
    this.revenuce = JdbcWritableBridge.readBigDecimal(3, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.order_date = JdbcWritableBridge.readString(1, __dbResults);
    this.department_name = JdbcWritableBridge.readString(2, __dbResults);
    this.revenuce = JdbcWritableBridge.readBigDecimal(3, __dbResults);
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
    JdbcWritableBridge.writeString(order_date, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(department_name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(revenuce, 3 + __off, 3, __dbStmt);
    return 3;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(order_date, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(department_name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(revenuce, 3 + __off, 3, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.order_date = null;
    } else {
    this.order_date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.department_name = null;
    } else {
    this.department_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.revenuce = null;
    } else {
    this.revenuce = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.order_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, order_date);
    }
    if (null == this.department_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, department_name);
    }
    if (null == this.revenuce) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.revenuce, __dataOut);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.order_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, order_date);
    }
    if (null == this.department_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, department_name);
    }
    if (null == this.revenuce) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.revenuce, __dataOut);
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
    __sb.append(FieldFormatter.escapeAndEnclose(order_date==null?"null":order_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(department_name==null?"null":department_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(revenuce==null?"null":revenuce.toPlainString(), delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(order_date==null?"null":order_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(department_name==null?"null":department_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(revenuce==null?"null":revenuce.toPlainString(), delimiters));
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
    if (__cur_str.equals("null")) { this.order_date = null; } else {
      this.order_date = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.department_name = null; } else {
      this.department_name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.revenuce = null; } else {
      this.revenuce = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.order_date = null; } else {
      this.order_date = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.department_name = null; } else {
      this.department_name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.revenuce = null; } else {
      this.revenuce = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    departments_revenue o = (departments_revenue) super.clone();
    return o;
  }

  public void clone0(departments_revenue o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("order_date", this.order_date);
    __sqoop$field_map.put("department_name", this.department_name);
    __sqoop$field_map.put("revenuce", this.revenuce);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("order_date", this.order_date);
    __sqoop$field_map.put("department_name", this.department_name);
    __sqoop$field_map.put("revenuce", this.revenuce);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
