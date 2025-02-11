import SwiftUI

struct FromTo: View {
    @State var from: String = ""
    @State var to: String = ""
    var body: some View {
        VStack {
            TextField(
                       "from",
                       text: $from
                   )
            TextField(
                       "to",
                       text: $to
                   )
        }
        .padding(.horizontal, 50)
        .textFieldStyle(.roundedBorder)
    }
}

#Preview {
    FromTo()
}
