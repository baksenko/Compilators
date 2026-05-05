package compiler.ast;

import java.util.List;

/**
 * Represents a reserved statement inside a message or enum.
 * Can contain field number ranges or field name strings.
 */
public class ReservedDef {
    private List<Range> ranges;       // numeric ranges (e.g. 2, 15, 9 to 11)
    private List<String> fieldNames;  // string field names

    public ReservedDef() {}

    public List<Range> getRanges() { return ranges; }
    public void setRanges(List<Range> ranges) { this.ranges = ranges; }

    public List<String> getFieldNames() { return fieldNames; }
    public void setFieldNames(List<String> fieldNames) { this.fieldNames = fieldNames; }

    /**
     * A numeric range [start, end]. If end == -1, it's a single value.
     * If end == Integer.MAX_VALUE, the range goes to max.
     */
    public static class Range {
        private int start;
        private int end; // -1 means single value, Integer.MAX_VALUE means "max"

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() { return start; }
        public int getEnd()   { return end; }
    }
}
