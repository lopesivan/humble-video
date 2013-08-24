/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.humble.video;
import io.humble.ferry.*;
public class Muxer extends Container {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    Buffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected Muxer(long cPtr, boolean cMemoryOwn) {
    super(VideoJNI.Muxer_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.
   */
  protected Muxer(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    super(VideoJNI.Muxer_SWIGUpcast(cPtr),
     cMemoryOwn, ref);
    swigCPtr = cPtr;
  }
    
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  protected static long getCPtr(Muxer obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  protected long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new Muxer object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  @Override
  public Muxer copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new Muxer(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof Muxer)
      equal = (((Muxer)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  
  @Override
  public String toString() {
    final StringBuilder b = new StringBuilder(super.toString());
    b.append("[")
    .append("url="+getURL()+";")
    .append("format:"+getFormat()+";")
    .append("]");
    return b.toString();
  }

/**
 * Creates a new muxer.<br>
 * <br>
 * One of the three passed in parameter must be non-null. If the muxer requires a URL to write to,<br>
 * then that must be specified.<br>
 * <br>
 * @param format If non null, this will be the format this muxer assumes it is writting packets in.<br>
 * @param filename The filename/url to open. If format is null, this will also be examined to guess actual format.<br>
 * @param formatName The formatname of the muxer to use. This will only be examined if format is null.<br>
 * <br>
 * @return a Muxer<br>
 * <br>
 * @throws InvalidArgument if all parameters are null.
 */
  public static Muxer make(String filename, MuxerFormat format, String formatName) {
    long cPtr = VideoJNI.Muxer_make(filename, MuxerFormat.getCPtr(format), format, formatName);
    return (cPtr == 0) ? null : new Muxer(cPtr, false);
  }

/**
 * Get the URL the Muxer was opened with.<br>
 * May return null if unknown.<br>
 * @return the URL opened, or null.
 */
  public String getURL() {
    return VideoJNI.Muxer_getURL(swigCPtr, this);
  }

/**
 * Get the MuxerFormat associated with this Muxer<br>
 * or null if unknown.
 */
  protected MuxerFormat getFormat() {
    long cPtr = VideoJNI.Muxer_getFormat(swigCPtr, this);
    return (cPtr == 0) ? null : new MuxerFormat(cPtr, false);
  }

/**
 * Get the current state of the Muxer.
 */
  public Muxer.State getState() {
    return Muxer.State.swigToEnum(VideoJNI.Muxer_getState(swigCPtr, this));
  }

  public void open(KeyValueBag inputOptions, KeyValueBag outputOptions) throws java.lang.InterruptedException, java.io.IOException {
    VideoJNI.Muxer_open(swigCPtr, this, KeyValueBag.getCPtr(inputOptions), inputOptions, KeyValueBag.getCPtr(outputOptions), outputOptions);
  }

  public void close() {
    VideoJNI.Muxer_close(swigCPtr, this);
  }

/**
 * Get the number of streams in this container.
 */
  public int getNumStreams() throws java.lang.InterruptedException, java.io.IOException {
    return VideoJNI.Muxer_getNumStreams(swigCPtr, this);
  }

/**
 * Set the buffer length Humble Video will suggest to FFMPEG for writing output data.<br>
 * <br>
 * If called when a Container is open, the call is ignored and -1 is returned.<br>
 * <br>
 * @param size The suggested buffer size.<br>
 * @throws InvalidArgument if size &lt;= 0
 */
  public void setOutputBufferLength(int size) {
    VideoJNI.Muxer_setOutputBufferLength(swigCPtr, this, size);
  }

/**
 * Return the output buffer length.<br>
 * <br>
 * @return The input buffer length Humble Video told FFMPEG to assume.<br>
 *   0 means FFMPEG should choose it's own<br>
 *   size (and it'll probably be 32768).
 */
  public int getOutputBufferLength() {
    return VideoJNI.Muxer_getOutputBufferLength(swigCPtr, this);
  }

/**
 * Adds a new stream that will have packets written to it.<br>
 * <br>
 * Note on thread safety: Callers must ensure that the coder is not encoding or decoding<br>
 * packets at the same time that Muxer#open or Muxer#close is being called.<br>
 * <br>
 * @param coder The coder that will be used for packets written to this stream.<br>
 * <br>
 * @throws InvalidArgument if encoder is null.<br>
 * @throws InvalidArgument if encoder is not open.
 */
  public MuxerStream addNewStream(Coder coder) {
    long cPtr = VideoJNI.Muxer_addNewStream(swigCPtr, this, Coder.getCPtr(coder), coder);
    return (cPtr == 0) ? null : new MuxerStream(cPtr, false);
  }

/**
 * Get the MuxerStream at the given position.
 */
  public MuxerStream getStream(int position) throws java.lang.InterruptedException, java.io.IOException {
    long cPtr = VideoJNI.Muxer_getStream(swigCPtr, this, position);
    return (cPtr == 0) ? null : new MuxerStream(cPtr, false);
  }

/**
 * Writes the given packet to the Muxer.<br>
 * <br>
 * @param packet The packet to write. If null, it tells the muxer to flush any data queued up to<br>
 *   the underlying storage (disk, network, etc).<br>
 * @param forceInterleave If true, this Muxer will ensure that all packets are interleaved across streams<br>
 *   (i.e. monotonically increasing timestamps in the Muxer container). If false, then the caller<br>
 *   is responsible for ensuring the interleaving is valid for the container. Note this method is faster<br>
 *   if forceInterleave is false.<br>
 * <br>
 * @return true if all data has been flushed, false if data remains to be flushed.<br>
 * <br>
 * @throws InvalidArgument if packet is null.<br>
 * @throws InvalidArgument if packet is not complete.<br>
 * @throws RuntimeException for other errors.
 */
  public boolean write(MediaPacket packet, boolean forceInterleave) {
    return VideoJNI.Muxer_write(swigCPtr, this, MediaPacket.getCPtr(packet), packet, forceInterleave);
  }

  /**
   * Muxers can only be in one of these states.
   */
  public enum State {
  /**
   * Initialized but not yet opened. Transitions to STATE_OPENED or STATE_ERROR.<br>
   * New streams can be added.
   */
    STATE_INITED,
  /**
   * File is opened, and header is written. For most formats,<br>
   * you can no longer add new streams. Check flags to find out if you can.
   */
    STATE_OPENED,
  /**
   * Trailer is written, file is closed and all file-resources have been released. The Muxer<br>
   * should be discarded.
   */
    STATE_CLOSED,
  /**
   * An error has occured.
   */
    STATE_ERROR,
  ;

    public final int swigValue() {
      return swigValue;
    }

    public static State swigToEnum(int swigValue) {
      State[] swigValues = State.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (State swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + State.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private State() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private State(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private State(State swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

}
